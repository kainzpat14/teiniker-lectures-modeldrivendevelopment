# LabExam Metamodelling Gruppe 1

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 10% of your grade in this LabExam.

## Steps

### Metamodelling 10%

Create a metamodel using whichever tool you want (or even by hand) using the domain description below. Make sure that the model is free of redundancies and that your UML nomenclature is correct. You can hand in your result either via Moodle or in paper. 

#### Domain: Telegrams

IT systems need to communicate. For this they usually use a set of well defined messages called telegrams. A specific telegram can either be only used for receiving, for sending or both. Each telegram has an internal name, which is used by the system to reference it and an identifier which is used for communication. A telegram can contain a list of fields, which either have a primitive type (String or Integer) or a complex type, but also have an internal name and an identifier. A complex type has a name and can again contain a list of fields, which once again are either primitive or complex. 

NOTE: A metamodel is not bound by the rules of java class modelling, so things like multiple inheritance are possible!

Examples in XML Notation (Telegram definitions are independent of the concrete transmission format): 

AliveTelegram (used for both input and output): 

```xml
<ALIVE></ALIVE>
```

TransportTelegram (only used as output): 

```xml
<TRANSPORT><BARCODE>4711</BARCODE><TARGET_ID>1234</TARGET_ID></TRANSPORT>
```

OrderTelegram (only used as input): 

```xml
<ORDER><IDENTIFIER>4711</IDENTIFIER><CUSTOMER><FIRSTNAME>John</FIRSTNAME><LASTNAME>Doe</LASTNAME></CUSTOMER></TRANSPORT>
```