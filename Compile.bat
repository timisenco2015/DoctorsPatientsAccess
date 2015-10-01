@echo off

REM
REM This script requires that the "javac" command be on the system command path.
REM This can be accomplished by removing the "REM" from the path statement below
REM and modifying it to include "C:\Program Files\Java\jdk1.7.0_60\bin" (or whatever
REM your path is).
REM
REM Alternatively, you could add the path to "javac" to the PATH Environment variable: 
REM   Settings-->Control Panel-->System-->Advanced-->Environment Variables-->Path
REM

REM path "C:\Program Files\Java\jdk1.7.0_60\bin";%PATH%

REM create classes folder if it does not already exist

if not exist bin md bin
if not exist bin\classes md bin\classes

REM clean all .class files out of the bin directory

cd bin\classes
erase /S /Q *.class
cd ..\..

call SetClasspath

@echo on

javac -d bin\classes -cp %classpath% src\comp3350\srsys\objects\*.java src\comp3350\dpa\persistence\*.java src\comp3350\dpa\application\*.java src\comp3350\dpa\business\*.java src\comp3350\dpa\presentation\CLI.java
javac -d bin\classes -cp %classpath% src\comp3350\tests\objects\*.java src\comp3350\tests\business\*.java src\comp3350\tests\*.java
