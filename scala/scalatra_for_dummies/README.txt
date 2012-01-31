This example is for players of Extreme Startup who can't
get an HTTP server to run in their prefered development
environment. It shows how to do HTTP listening, regexp
and testing in Scala.

Getting started:
1. cd to this directory
2. "sbt test" - run all the tests
  (this takes a while the first time, as sbt downloads dependencies)
3. "sbt run" - starts the server
  (this currently does not respond to ctrl-c on Windows and must be killed with task manager)
4. Go and see the server in action:
  http://localhost:1337/?q=what+is+the+sum+of+8+and+22
5. Try and modify the number in the above URL and verify
  that the answer is correct