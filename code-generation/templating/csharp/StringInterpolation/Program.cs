using System;
using System.Linq;
using GeneratorUtils;
using Metamodel;

namespace StringInterpolation
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(generate(ModelGenerator.GetDefaultEntity()));
        }

        static String generate(MEntity entity)
        {
            return $@"
package at.fhj.mdd;

public {entity.Name.FirstCharToUpper()} {{
    {String.Join("",entity.Attributes.Select(generate))}
    
    public {entity.Name.FirstCharToUpper()}({String.Join(",", entity.Attributes.Select(generateParameter))} {{
        {String.Join("",entity.Attributes.Select(generateAssignment))}
    }}
}}
";
        }

        static String generate(MAttribute attribute)
        {
            return $@"
    private {generate(attribute.Type)} {attribute.Name.FirstCharToLower()};

    public {generate(attribute.Type)} get{attribute.Name.FirstCharToUpper()}() {{
        return this.{attribute.Name.FirstCharToLower()};
    }}

    public void set{attribute.Name.FirstCharToUpper()}({generateParameter(attribute)}) {{
{generateAssignment(attribute)}
    }}
";
        }

        static String generateParameter(MAttribute attribute)
        {
            return $@"{generate(attribute.Type)} {attribute.Name.FirstCharToLower()}";
        }

        static String generateAssignment(MAttribute attribute)
        {
            return $@"
        this.{attribute.Name.FirstCharToLower()} = {attribute.Name.FirstCharToLower()};";
        }

        static string generate(MType type)
        {
            switch (type)
            {
                case  MType.Integer: return "int";
                case MType.String: return "String";
                default: throw new ArgumentException("Unsupported type " + type);
            }
        }
    }
}