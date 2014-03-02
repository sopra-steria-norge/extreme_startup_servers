This example is for players of Extreme Startup who can't get an HTTP
server to run in their prefered development environment. It shows how
to do HTTP listening,
[definite clause grammar](http://www.pathwayslms.com/swipltuts/dcg/)
in SWI-Prolog. Prolog uses definite clause grammars instead of regular
expressions.

Getting started:
  1. Install [SWI-Prolog](http://www.swi-prolog.org/download/stable)
  2. Make sure `swipl` is in your path.
  3. cd to this directory
  4. Run `swipl -s server.pl`
  5. Go and see the server in action: http://localhost:1337/?q=23fa3:+what+is+the+sum+of+8+and+22
  6. Change module to `answers` by writing `module(answers).` into the interpreter.
  7. Edit `answers.pl` to answer new questions.
  8. Enter `make.` to reload answers into interpreter.

To watch the request/response to/from the server you can follow the
log by opening `tail -f httpd.log` in a new terminal window.

The reason for having two different files, `server.pl` and
`answers.pl`, is to have different namespaces for the server and the
answers part. This way when we reload answers, we don't reload the
server as well.
