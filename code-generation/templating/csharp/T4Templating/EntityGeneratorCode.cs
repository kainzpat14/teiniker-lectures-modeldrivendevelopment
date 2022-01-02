using System;
using Metamodel;

namespace T4Templating
{
    public partial class EntityGenerator
    {
        private MEntity entity;

        public EntityGenerator(MEntity entity)
        {
            this.entity = entity;
        }
    
        private string getType(MType type)
        {
            switch (type)
            {
                case  MType.Integer: return "int";
                case MType.String: return "String";
                default: throw new ArgumentException("Unsupported type " + type);
            }
        }
    }
}