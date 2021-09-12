# LabExam Metamodelling Gruppe 1

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 10% of your grade in this LabExam.

## Steps

### Metamodelling 10%

Create a metamodel using whichever tool you want (or even by hand) using the domain description below. Make sure that the model is free of redundancies and that your UML nomenclature is correct. You can hand in your result either via Moodle or in paper. 

#### Domain: Installer

Installing applications mostly follows the same pattern. An installer usually has three phases: Preparation, Install, Cleanup. During each phase a number of tasks are performed one after the other. While Tasks during Preparation and Cleanup are not expected to fail and cannot be undone, the Install steps can be undone and have therefore corresponding undo steps. The following steps are available: 
- Copy a file (source and destination required)
- Create a folder (foldername required)
- Execute shell script (shellscript name required)
- Output to the user (header and text required)

Example: 

Preparation: 
- Output to the user (header="Installation will now proceed", text="We will now be installing your software, please wait")
- Execute shell script (name="checkPreconditions.sh")
Install:
- Create a folder (foldername=/opt/myprogram), Undo: Execute Shell script (name="cleanup_myprogram_folder.sh")
- Copy a file (source="myprogram", destination="/opt/myprogram/myprogram"), Undo: Execute Shell script (name="cleanup_myprogram_folder.sh")
Cleanup:
- Execute shell script(name="cleanupTmp.sh")
- Output to the user (header="Success!", text="Installation is now complete, or not, check yourself")