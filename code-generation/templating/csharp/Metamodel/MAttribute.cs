using System;

namespace Metamodel
{
    public struct MAttribute
    {
        public MType Type { get; }
        public String Name { get; }

        public MAttribute(MType type, string name)
        {
            Type = type;
            Name = name;
        }
    }
}