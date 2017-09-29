set JAVA_HOME=D:\Dropbox\work\tools\jdk8
set path=%JAVA_HOME%\bin;%path%

if %PROCESSOR_ARCHITECTURE% EQU "x86" (DLL_PATH=./x86) ELSE ( set DLL_PATH=./x64) 

cd "%~dp0"

java -cp "classes;lib/*" -Djava.library.path="%DLL_PATH%" groovy.ui.GroovyMain SampleScript.groovy

pause
