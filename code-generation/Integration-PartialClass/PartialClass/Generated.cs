using System;
namespace PartialClass
{
    public partial class HalfClass
    {
        public void GeneratedMethod1()
        {
            Console.WriteLine("Generated code being called");
        }

        public void GeneratedMethod2()
        {
            Console.WriteLine("Generated code calling");
            ManualMethod();
        }
    }
}
