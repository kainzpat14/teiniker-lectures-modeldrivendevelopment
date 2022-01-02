using System.Collections.Generic;
using System.Linq;
using Microsoft.CodeAnalysis;
using Microsoft.CodeAnalysis.CSharp.Syntax;

namespace Generator;

public class GenerateBuilderClassesSyntaxReceiver : ISyntaxContextReceiver
{
    public List<INamedTypeSymbol> Classes { get; } = new();
    public void OnVisitSyntaxNode(GeneratorSyntaxContext context)
    {
        if (context.Node is ClassDeclarationSyntax)
        {
            var clazz = context.SemanticModel.GetDeclaredSymbol(context.Node) as INamedTypeSymbol;
            if (clazz!.GetAttributes().Any(it => it.AttributeClass!.Name.Equals(nameof(GenerateBuilder))))
            {
                Classes.Add(clazz);
            }
        }
    }
}