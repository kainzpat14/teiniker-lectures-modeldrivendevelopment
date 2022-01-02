using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.CodeAnalysis;

namespace Generator;

[Generator]
public class BuilderGenerator : ISourceGenerator
{
    public void Initialize(GeneratorInitializationContext context)
    {
        context.RegisterForSyntaxNotifications(() => new GenerateBuilderClassesSyntaxReceiver());
    }

    public void Execute(GeneratorExecutionContext context)
    {
        if (context.SyntaxContextReceiver is not GenerateBuilderClassesSyntaxReceiver receiver)
            return;
            
            
        foreach(var classWithBuilder in receiver.Classes)
        {
            var code = GenerateBuilder(classWithBuilder); 
            context.AddSource(classWithBuilder.Name+"Builder",code);
        }
    }

    private string GenerateBuilder(INamedTypeSymbol classWithBuilder)
    {
        var properties = classWithBuilder.GetMembers().Where(member => member is IPropertySymbol).Cast<IPropertySymbol>();
        var hasDefaultConstructor =
            classWithBuilder.Constructors.Any(constructor => constructor.Parameters.IsEmpty);
        if (!hasDefaultConstructor)
        {
            properties = GetOrderedSymbols(classWithBuilder, properties);
        }

        var code = GenerateBuilder(classWithBuilder, properties, hasDefaultConstructor);
        return code;
    }

    private string GenerateBuilder(INamedTypeSymbol classWithBuilder, IEnumerable<IPropertySymbol> properties,
        bool hasDefaultConstructor)
    {
        var code = $@"
using System;

namespace {classWithBuilder.ContainingNamespace.Name} {{
    public class {classWithBuilder.Name}Builder {{
        {string.Join("", properties.Select(prop => GenerateProperties(classWithBuilder, prop)))}
        
        public {classWithBuilder.Name} Build() {{
            {GenerateBuildMethodContents(classWithBuilder, properties, hasDefaultConstructor)}
        }}
    }}
}}
";
        return code;
    }

    private string GenerateBuildMethodContents(INamedTypeSymbol classWithBuilder,
        IEnumerable<IPropertySymbol> properties, bool hasDefaultConstructor)
    {
        if (hasDefaultConstructor)
        {
            return $@"var instance = new {classWithBuilder.Name}();
            {string.Join("\n", properties.Select(GenerateAssignment))}
            return instance;
";
        }

        return
            $"return new {classWithBuilder.Name}({string.Join(",", properties.Select(GenerateConstructorPass))});";
    }

    private string GenerateConstructorPass(IPropertySymbol propertySymbol)
    {
        if (propertySymbol.Type.Name.Equals("int") || propertySymbol.Type.Name.Equals("Int32"))
        {
            return propertySymbol.Name.FirstCharToLower() + "?? default(int)";
        }
        return propertySymbol.Name.FirstCharToLower() + (propertySymbol.Type.Name.EndsWith("?") ? "" : "!");
    }
    private string GenerateAssignment(IPropertySymbol propertySymbol)
    {
        return $"instance.{propertySymbol.Name}={GenerateConstructorPass(propertySymbol)};";
    }
        
    private string GenerateProperties(INamedTypeSymbol clazz, IPropertySymbol propertySymbol)
    {
        var propertyType = propertySymbol.Type.Name + (propertySymbol.Type.Name.EndsWith("?") ? "" : "?");
        return $@"
        private {propertyType} {propertySymbol.Name.FirstCharToLower()} = null;
        
        public {clazz.Name}Builder With{propertySymbol.Name}({propertySymbol.Type.Name} {propertySymbol.Name.FirstCharToLower()}) {{
            this.{propertySymbol.Name.FirstCharToLower()} = {propertySymbol.Name.FirstCharToLower()};
            return this;
        }}
";
    }

    private List<IPropertySymbol> GetOrderedSymbols(INamedTypeSymbol clazz, IEnumerable<IPropertySymbol> properties)
    {
        var errorMessage = "Expected Constructor: " +
                              string.Join(",", properties.Select(prop => prop.Type.Name + " " + prop.Name))+" Found Constructors: ";
        foreach (var constructor in clazz.Constructors)
        {
            errorMessage += "(" +
                            String.Join(",", constructor.Parameters.Select(prop => prop.Type + " " + prop.Name)) +
                            ") ";
            if (constructor.Parameters.Length == properties.Count())
            {
                var orderedSymbols = new List<IPropertySymbol>();
                foreach (var parameter in constructor.Parameters)
                {
                    var matchingProperty = properties.FirstOrDefault(prop =>
                        !orderedSymbols.Contains(prop) &&
                        TypeMatches(prop.Type, parameter.Type) &&
                        NameMatches(prop.Name, parameter.Name));
                        
                    if (matchingProperty != null)
                    {
                        orderedSymbols.Add(matchingProperty);
                    }
                    else
                    {
                        errorMessage += "[Unable to find " + parameter.Type.Name + " " + parameter.Name+"]";
                        break;
                    }
                }

                if (orderedSymbols.Count() == properties.Count())
                {
                    return orderedSymbols;
                }

                errorMessage += "[Symbol mismatch("+orderedSymbols.Count()+"!="+properties.Count()+")]";
            }
            else
            {
                errorMessage += "[Count mismatch]";
            }
        }

        throw new Exception("Unable to find matching constructor with properties, cannot generate for class " + clazz.Name+" Message: "+errorMessage);
    }

    private bool TypeMatches(ITypeSymbol propType, ITypeSymbol parameterType)
    {
        return propType.Name.ToLower().Equals(parameterType.Name.ToLower()) ||
               (propType.Name.Equals("Int32") || parameterType.Name.Equals("Int32")) &&
                (propType.Name.Equals("int") || parameterType.Name.Equals("int"));
    }

    private bool NameMatches(string propName, string parameterName)
    {
        return propName.ToLower().Equals(parameterName.ToLower());
    }
}