from jinja2 import Environment, select_autoescape, FileSystemLoader

from model import entity, MType
from stringFunctions import decapitalize

env = Environment(
    loader=FileSystemLoader('templates'),
    autoescape=select_autoescape()
)
env.globals["decapitalize"] = decapitalize
env.globals["MType"]=MType
template = env.get_template("entity.java")
print(template.render(entity=entity))
