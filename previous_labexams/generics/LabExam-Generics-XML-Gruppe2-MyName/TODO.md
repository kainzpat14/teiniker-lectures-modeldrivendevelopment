# LabExam Generics Gruppe 2

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 10% of your grade in this LabExam.

## Steps

### Annotation syntax 2%

Complete the TODOs in FieldMapping and TelegramMapping by including the appropriate settings for each annotation: 
- Both annotations need to be read at runtime
- FieldMapping is only allowed for fields
- TelegramMapping is only allowed for classes

### Annotation Processing and Reflections 4%

Complete the TODOs in ReflectionUtil: 
- Only return fields in getTelegramFields which have a FieldMapping assigned to them
- Read element names for classes and fields from their corresponding TelegramMapping and FieldMapping annotations, ensure that an error is thrown if the annotation is not present.

### Generic Implementation 4%

Provide an abstract basis class GenericXmlConverter for both AliveXmlConverter and TransportXmlConverter, which will perform all operations in a generic way, for this utilize Generics and Reflections. Don't forget to use the functions available in ReflectionUtil. As a result both AliveXmlConverter and TransportXmlConverter should only contain their constructors.

Validate your implementation using TestXmlConverter.

Notes: 
- Do not change the method signatures, catch any checked exceptions you encounter