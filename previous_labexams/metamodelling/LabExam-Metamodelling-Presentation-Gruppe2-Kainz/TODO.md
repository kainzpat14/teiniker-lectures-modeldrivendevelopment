# LabExam Metamodelling Gruppe 2

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 10% of your grade in this LabExam.

## Steps

### Metamodelling 10%

Create a metamodel using whichever tool you want (or even by hand) using the domain description below. Make sure that the model is free of redundancies and that your UML nomenclature is correct. You can hand in your result either via Moodle or in paper. 

#### Domain: Presentation

All of us are familiar with presentations. We probably can't count how many slides we have created in our lives. Typically a presentation consists of a number of slides, where one slide follows the other. A slide has a header and can contain a number of pictures, lists or text. In addition a slide can contain a subsection, which may once again contain pictures, lists, text or further subsections. 

NOTE: A metamodel is not bound by the rules of java class modelling, so things like multiple inheritance are possible!

If a presentation would be rendered in XML it might look like this: 

```xml
<presentation>
	<slide>
		<header>Lab Exams</header>
		<text>Things to not forget:</text>
		<list>
			<bulletPoint>Rename your project</bulletPoint>
			<bulletPoint>Make sure to hand in in time</bulletPoint>
		</list>
	</slide>
	<slide>
		<header>I wish you</header>
		<text>the best of luck and</text>
		<container>
			<text>FUN!</text>
			<picture>Smiley</picture>
		</container>
	</slide>
</presentation>
```

