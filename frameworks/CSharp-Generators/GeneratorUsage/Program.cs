using System;
namespace GeneratorUsage;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello World!");
        Console.WriteLine(new MStudentBuilder()
            .WithFirstName("Patrick")
            .WithLastName("Kainz")
            .WithMatNr(1234)
            .Build());
    }
}