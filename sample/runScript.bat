set JAVA_HOME=D:\Dropbox\work\tools\jdk8
set path=%JAVA_HOME%\bin;%path%

cd "%~dp0"

java -cp "classes;lib/*" groovy.ui.GroovyMain SampleScript.groovy

pause
