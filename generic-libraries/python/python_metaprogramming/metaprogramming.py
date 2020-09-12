from cProfile import label

def entity_persist(self, cls, dict):
    print("INSERT INTO "+self.tablename()+" VALUES (TODO);")

# since in python all classes are also objects and those objects hold a metaclass, we can change that metaclass
# to define specific functionality, in this case we define a different type of class which is an entity
# that needs to be assigned to a tablename and gets a custom persist function. 
# of course this example would have been much easier with a base class Entity, but this illustrates
# that code can be generated upon creation of a class
class EntityMeta(type):
    def __new__(cls, what, bases=None, dict=None):
        if not 'tablename' in dict:
            raise Exception("Entity "+str(cls)+" needs a tablename() function")
        obj = type.__new__(cls,what,bases,dict)
        obj.persist = lambda self: entity_persist(self, cls, dict)
        return obj

class MyEntity(metaclass=EntityMeta):
    def tablename(self): 
        return "MY_ENTITY"
    
    def __init__(self, idN, name):
        self.idN = idN
        self.name = name

#class AnotherEntity(metaclass=EntityMeta):  
#    def __init__(self, id, name):
#        self.id = id
#        self.name = name
         

MyEntity(1, "Patrick Kainz").persist()
