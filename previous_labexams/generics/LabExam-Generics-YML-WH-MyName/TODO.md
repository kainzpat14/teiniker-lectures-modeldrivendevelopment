# LabExam Generics Repetition

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 12,5% = 10pts of your grade in this LabExam.

## Steps

Configuration data is often stored as so called YAML files. YAML files are hierarchically structured files like XML and JSON, but use a python like intentation based syntax. We will develop a serializer that will enable us to render any configuration class as YML. For this we provide the two annotations YmlAttribute and YmlEntity to define the name of a certain class attribute or a class in YML. 

### Annotation syntax 2pts

Complete the TODOs in YmlAttribute and YmlEntity by including the appropriate settings for each annotation: 
- Both annotations need to be read at runtime
- YmlAttribute is only allowed for fields
- YmlEntity is only allowed for classes

### Annotation Processing and Reflections 4pts

Complete the TODOs in ReflectionUtil: 
- getYmlName should take either a class or a field as parameter and check if an YmlAttribute or YmlEntity annotation is present and if so return the name contained within
- getReadableYmlFields should return a list of all fields with a YmlAttribute. Should you run
  into any problems with field visibilities fix them here. 

### Generic Implementation 4pts

Using ClientSettingsSerializer as a template and utilizing ReflectionUtil create a generic implementation SettingsSerializer, which will serialize any of the two Settings classes in the model package (and also any future settings classes). 

Validate your implementation using TestSerializer. 

Notes: 
- Do not change the method signatures, catch any checked exceptions you encounter