from enum import Enum


class MType(Enum):
    INT = 1
    STRING = 2


class MAttribute:
    name: str
    type: MType

    def __init__(self, name: str, type: MType):
        self.name = name
        self.type = type


class MEntity:
    name: str
    attributes: list = []

    def __init__(self, name: str):
        self.name = name


entity = MEntity("MyEntity")
entity.attributes.append(MAttribute("strField", MType.STRING))
entity.attributes.append(MAttribute("intField", MType.INT))
