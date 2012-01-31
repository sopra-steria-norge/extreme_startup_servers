This example is for players of Extreme Startup who can't
get an HTTP server to run in their prefered development
environment. It shows how to do HTTP listening, regexp
and testing in Java with Jetty.

Getting started:
1. Install Maven from http://maven.apache.org
2. Make sure mvn is in your path
3. cd to this directory
4. "mvn eclipse:eclipse -DdownloadSources" - create Eclipse project (or IDEA)
5. Import the project into Eclipse
   - If this is your first run-in with Maven, go to
     Window > Preferences : Java > Build path > Classpath Variable
     and add M2_REPO as <your home dir>/.m2/repository
6. Run ExtremeStartupTest as a JUnit test
7. Run ExtremeStartup as a Java main class
8. Go and see the server in action:
  http://localhost:1337/?q=what+is+the+sum+of+8+and+22
9. Try and modify the number in the above URL and verify
  that the answer is correct
