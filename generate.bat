set JAVA_HOME=D:\Dropbox\work\tools\jdk8
set path=%JAVA_HOME%\bin;%path%

cd "%~dp0"

java -cp lib\antlr-4.7-complete.jar org.antlr.v4.Tool -no-listener -no-visitor src\com\branegy\populito\parser\Populito.g4
pause