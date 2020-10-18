using System;
namespace PartialClass
{
    public partial class HalfClass
    {
        public void ManualMethod()
        {
            Console.WriteLine("Manual code called and calling");
            GeneratedMethod1();
        }
    }
}
