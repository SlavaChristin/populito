set JAVA_HOME=D:\Dropbox\work\tools\jdk8
set path=%JAVA_HOME%\bin;%path%

javadoc -cp classes;lib\antlr-4.7-complete.jar;lib\automaton.jar -d docs\javadoc -sourcepath src com.branegy.populito com.branegy.populito.formatter com.branegy.populito.functions | more
