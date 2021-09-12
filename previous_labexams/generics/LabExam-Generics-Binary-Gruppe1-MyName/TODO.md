# LabExam Generics Gruppe 1

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 12,5% = 10pts of your grade in this LabExam.

## Steps

Machines such as the systems in a car, IoT devices or PLC (Programmable Logic Controller) often use fixed length binary protocols. Some 
programming languages make it very easy to implement such protocols, for example in C/C++ you can simply create a struct with the same memory layout as the message you wish to sent and can cast it to a char array:

//this code was never compiled, so no guarantees its actually correct :D 

struct {
	int speed;
	char reserved[6];
	double batteryVoltage;
	char reserved2[6];
} StatusMessage;

//sending
struct StatusMessage message;
message.speed = 100;
message.batteryVoltage = 9.0;

char* bytes = (char*)&message;

//receiving
StatusMessage receivedMessage = *((StatusMessage*)bytes);


Of course this approach completely forgoes any error checking, which is why it should never be used in practice, but it is still possible. 

In Java this is not the case, here we have to read field for field into an object, since we cannot simply cast a buffer into an object reference. In order to make this easier we will now implement something similar allowing us to convert any data class directly into a byte array and back. This approach does of course exhibit worse performance when compared to the C/C++ solution, but at least it has the same usability.


### Annotation syntax 2pts

Complete the TODOs in FieldBinaryMapping and MessageBinaryMapping by including the appropriate settings for each annotation: 
- Both annotations need to be read at runtime
- FieldBinaryMapping is only allowed for fields
- MessageBinaryMapping is only allowed for classes

### Annotation Processing and Reflections 4pts

Complete the TODOs in ReflectionUtil: 
- getMessageSize should check if an MessageBinaryMapping attribute is present and should then return its totalSize
- getOffset should return the offset of the FieldBinaryMapping
- getReadableSortedFields should return a list of all fields with a FieldBinaryMapping sorted by the offset ascending. Should you run
  into any problems with field visibilities fix them here. 

### Generic Implementation 4pts

Using StatusMessageSerializer as a template and utilizing ReflectionUtil create a generic implementation MessageSerializer, which will serialize any of the three Message classes in the model package (and also any future message classes). 

Validate your implementation using TestSerializer. 

Notes: 
- Do not change the method signatures, catch any checked exceptions you encounter