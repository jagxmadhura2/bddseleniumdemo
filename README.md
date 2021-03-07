# bddseleniumdemo

#This framework will be implemented using cucumber bdd with selenium java
#download and keep the chromedriver, i have used mac so in util>> applicationconstant>> add chrome.exe for windows, for mac .exe is not required

#To run from command line as cicd process in jenkins build >> execute shell add below items
 export M2_HOME=//Applications/jagadeesh/maven/apache-maven-3.6.3
 export M2=$M2_HOME/bin
 export PATH=$M2:$PATH
#provide ur local machine code path
cd /Applications/jagadeesh/ui/bddseleniumdemo

#this command will execute all the test runners as per the pom.xml
mvn test

#for parallel execution create multiple testrunner for different features and include the path in pom.xml
