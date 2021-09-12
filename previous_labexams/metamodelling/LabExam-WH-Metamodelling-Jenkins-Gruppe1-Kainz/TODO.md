# LabExam Metamodelling Gruppe 1

## Important
Before you start rename the folder, Intellij/Eclipse Project and Maven project by replacing MyName with your Lastname. If you forget this you WILL lose 50% of your points. 
Compiler errors are not tolerated, you will lose all of your points if the code does not compile. Furthermore, it is not possible to get 100% if the tests fail.

You need to upload in time, note that delays because of your software or hardware malfunctioning cannot be considered, so ensure that everything is working fine BEFORE you give the lecturer the go ahead to start. 

You can earn 10% of your grade in this LabExam.

## Steps

### Metamodelling 10%

Create a metamodel using whichever tool you want (or even by hand) using the domain description below. Make sure that the model is free of redundancies and that your UML nomenclature is correct. You can hand in your result via Moodle

#### Domain: Jenkins Jobs

Jenkins is one of the most used continuous integration systems. A Jenkins Job has a name and is triggered by a certain event: 
- A Change in the Versioning System reachable via a given URL
- Reaching of a certain point in time specifyable via a crontab expression as String
- Completion of another job
After being triggered, the job then executes 3 phases: prebuild, build and postbuild. The build phase can only be executed if the prebuild phase was successfull. The postbuild phase is always executed. 
A phase consists of a number of tasks, each of which can fail. If it does no further tasks are executed in 
that phase. 
The available tasks are: 
- Execute a bash script under a given filesystem path (available in prebuild, build and postbuild)
- Run a certain maven command specified as string (available in build only)
- Send a mail with the result of the build to a list of mail addresses (available in postbuild only)


Multiple examples of such jobs would be: 

Job Build my cool system:
Trigger: Check into url https://github.com/me/mycoolsystem.git 
prebuild: Nothing
build: run mvn clean install deploy
postbuild: send mail to me@me.com

Job Test my cool system:
Trigger: Completion of job "Build my cool system"
prebuild: run script /root/startCoolSystem.sh
build: run mvn test
postbuild: send mail to me@me.com, run script /root/archiveLogs.sh

Job Cleanup database
Trigger: Cron expression 0 0 0 * * 
prebuild: nothing
build: run script /root/cleanDB.sh
postbuild: Nothing
