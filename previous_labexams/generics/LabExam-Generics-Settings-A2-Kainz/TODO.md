# LabExam Generics Attempt 2

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 12,5% = 10pts of your grade in this LabExam.

## Steps

Configuration data is often stored as so called INI files. These files are grouped into sections where each section has a number of different settings represented as key value pairs. We will develop a storage that will enable us to render any configuration class as INI. For this we provide the two annotations Setting and SettingObject to define the key of a certain class attribute or the name of the section for a class in INI. 

### Annotation syntax 2pts

Complete the TODOs in Setting and SettingObject by including the appropriate settings for each annotation: 
- Both annotations need to be read at runtime
- Setting is only allowed for fields
- SettingObject is only allowed for classes

### Annotation Processing and Reflections 4pts

Complete the TODOs in ReflectionUtil: 
- getObjectName should take a class as parameter and check if a SettingObject annotation is present and if so return the name contained within
- getSettingKey should take a field as parameter and check if a Setting annotation is present and if so return the key contained within
- getReadableSettingFields should return a list of all fields with a Setting. Should you run
  into any problems with field visibilities fix them here. 

### Generic Implementation 4pts

Using ClientSettingsStorage as a template and utilizing ReflectionUtil create a generic implementation SettingsStorage, which will render any of the two Settings classes in the model package (and also any future settings classes). 

Validate your implementation using TestStorage. 

Notes: 
- Do not change the method signatures, catch any checked exceptions you encounter