using System;
using System.Collections.Generic;

namespace csharp_generics
{

    class Base
    {

    }

    class Concrete : Base
    {
        int value;

        public Concrete(int value)
        {
            this.value = value;
        }

        public Concrete()
        {
            this.value = 10;
        }

        public override string ToString()
        {
            return value.ToString();
        }
    }

    class Program
    {

        // The C# compiler does not destroy the type information after compilation.
        // instead it works similarly to the C++ by compiler, by copying the generic implementation
        // to a specific one. This way we can even instantiate generic types, provided the type
        // has a default constructor which we ensure via the new() constraint.
        // The getput Problem is also solved differently than in Java, instead of a different inheritance
        // scheme, the compiler does not allow inheritance, instead we must use two types, which are connected
        // via constraints.
		static void Copy<T,U>(List<U> source, List<T> target) where U : T, new() {
			foreach(T sourceElem in source)
            {
                target.Add(sourceElem);
            }
            target.Add(new U());
		}

        // Since unlike the C++ compiler the C# compiler actually performs type checking on the generic type and not
        // on the specific instance, we must provide constraints to enable us to use functions we expect the type to
        // support
        static void BubbleSort<T>(List<T> list) where T : IComparable
        {
            for(int i = 0;i<list.Count - 1; i++)
            {
                for(int j = 0; j<list.Count - i - 1; j++)
                {
                    if(list[j].CompareTo(list[j+1]) > 0)
                    {
                        var tmp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = tmp;
                    }
                }
            }
        }

        // Since C# also creates copies of methods and does not just erase the type information, we can have multiple methods with different generic types:
        static void Output(List<int> intList)
        {
            Console.WriteLine(String.Join(",",intList));
        }

        static void Output(List<double> doubleList)
        {
            Console.WriteLine(String.Join(",",doubleList));
        }

        // Like in C++ its also possible to override a specific type with a different implementation:
        static int Compare<T>(T value1, T value2) where T : IComparable
        {
            return value1.CompareTo(value2);
        }

        static int Compare(int value1, int value2)
        {
            return value2 - value1;
        }

        static void Main(string[] args)
        {
            var source = new List<Concrete> { new Concrete(1), new Concrete(2), new Concrete(3) };
            var target = new List<Base>();
            Copy(source,target);

            Console.WriteLine(String.Join(",", target));

            var numeric = new List<int> { 5, 4, 3, 2, 1 };
            BubbleSort(numeric);
            Console.WriteLine(String.Join(",", numeric));

            Console.WriteLine(Compare(1, 2));
            Console.WriteLine(Compare(1.0, 2.0));

            var intStack = new Stack<int>();
            var doubleStack = new Stack<double>();
            intStack.Put(1);
            intStack.Put(2);
            Console.WriteLine(intStack.Pop() + "," + intStack.Pop());

            doubleStack.Put(1.0);
            doubleStack.Put(2.0);
            Console.WriteLine(doubleStack.Pop() + "," + doubleStack.Pop());

            var stringStack = new Stack<String>();
            stringStack.Put("a");
            stringStack.Put("b");
            Console.WriteLine(stringStack.Pop() + "," + stringStack.Pop());

            //Like C++ the compiler copies instances, so the static variables are available per type, not globally like in Java
            Console.WriteLine("Used int: " + StackNode<int>.UsageCounter+ " double: "+ StackNode<double>.UsageCounter+ " string: "+ StackNode<String>.UsageCounter);
        }
    }

    // Reflection: https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/concepts/reflection
    // C# supports reflection just as Java, with the additional advantage that its possible to generate classes at runtime
    // which Java only supports via a custom class loader.
}
