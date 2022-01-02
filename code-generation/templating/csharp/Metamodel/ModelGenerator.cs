using System.Collections.Generic;

namespace Metamodel
{
    public class ModelGenerator
    {
        public static MEntity GetDefaultEntity()
        {
            return new MEntity("MyEntity", new List<MAttribute>
            {
                new MAttribute(MType.Integer, "intAttribute"),
                new MAttribute(MType.String, "stringAttribute")
            });
        }
    }
}