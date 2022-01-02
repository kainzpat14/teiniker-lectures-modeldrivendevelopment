using System;
using System.Collections.Generic;

namespace Metamodel
{
    public struct MEntity
    {
        public String Name { get; }
        public List<MAttribute> Attributes { get; }

        public MEntity(string name, List<MAttribute> attributes)
        {
            Name = name;
            Attributes = attributes;
        }
    }
}