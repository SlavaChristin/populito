set JAVA_HOME=D:\Dropbox\work\tools\jdk8
set path=%JAVA_HOME%\bin;%path%

cd "%~dp0"


rd /s /q "classes"
mkdir classes
javac -cp "lib/*" -sourcepath src src\com\branegy\populito\*.java src\com\branegy\populito\functions\*.java src\com\branegy\populito\formatter\*.java  -d classes 

rd /s /q "target"
mkdir target
jar -cf0 target\populito.jar -C classes .

