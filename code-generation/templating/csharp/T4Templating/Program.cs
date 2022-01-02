using System;
using Metamodel;

namespace T4Templating
{
    class Program
    {
        static void Main(string[] args)
        {
            EntityGenerator generator = new EntityGenerator(ModelGenerator.GetDefaultEntity());
            Console.WriteLine(generator.TransformText());
        }
    }
}