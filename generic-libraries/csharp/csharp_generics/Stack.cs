using System;

namespace csharp_generics
{
	class StackNode<T>
	{
		public static int UsageCounter = 0;
		public T Value { get; set; }
		public StackNode<T> Next { get; set; }

		public StackNode(T value)
        {
			this.Value = value;
			UsageCounter++;
        }
    }

	class Stack<T> {
		StackNode<T> top = null;

		public void Put(T value)
        {
			StackNode<T> newTop = new StackNode<T>(value);
			newTop.Next = top;
			top = newTop;
        }

		public T Pop()
        {
			if(top == null)
            {
				throw new Exception("Stack empty");
            }
			T value = top.Value;
			top = top.Next;
			return value;
        }
	}
}