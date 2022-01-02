using System;
using Generator;

namespace GeneratorUsage;

[GenerateBuilder]
public class MStudent
{
    public string FirstName { get; }
    public string LastName { get; }
    public int MatNr { get; }

    public MStudent(string firstName, string lastName, Int32 matNr)
    {
        FirstName = firstName;
        LastName = lastName;
        MatNr = matNr;
    }

    public override string ToString()
    {
        return "MStudent(" + FirstName + "," + LastName + "," + MatNr + ")";
    }
}