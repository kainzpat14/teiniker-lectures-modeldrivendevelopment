from model import entity, MEntity, MAttribute, MType
from stringFunctions import decapitalize

newline="\n"

def generate_parameter(attribute : MAttribute):
    return f"this.{decapitalize(attribute.name)} = {decapitalize(attribute.name)};"

def generate_type(type : MType):
    if type == MType.INT:
        return "int"
    elif type == MType.STRING:
        return "String"
    else:
        raise Exception("Invalid type",type)


def generate_assignment(attribute : MAttribute):
    return f"{generate_type(attribute.type)} {decapitalize(attribute.name)}"

def generate_attribute(attribute : MAttribute):
    return f"""
        private {generate_type(attribute.type)} {decapitalize(attribute.name)};
        
        public {generate_type(attribute.type)} get{attribute.name.capitalize()}() {{
            return this.{decapitalize(attribute.name)};
        }}
        
        public void set{attribute.name.capitalize()}() {{
            this.{decapitalize(attribute.name)} = {decapitalize(attribute.name)};
        }}
    """

def generate_entity(entity : MEntity):
    return f"""
    package at.fhj.mdd;
    
    public class {entity.name.capitalize()} {{
        {"".join(map(generate_attribute, entity.attributes))}
        
        public {entity.name.capitalize()}({",".join(map(generate_parameter, entity.attributes))}) {{
            {f"{newline}            ".join(map(generate_assignment, entity.attributes))}
        }}
    }}
    """

print(generate_entity(entity))