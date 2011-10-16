This example is for players of Extreme Startup who can't
get an HTTP server to run in their prefered development
environment. It shows how to do HTTP listening, regexp
and testing in Ruby.

Getting started:
1. Download Ruby from http://ruby-lang.org
2. Make sure ruby is in your patch
3. "gem install sinatra"
4. cd to this directory
5. "rspec ." - run all the tests
6. "ruby extreme_startup.rb" - starts the server
7. Go and see the server in action:
  http://localhost:1337/?q=what+is+the+sum+of+8+and+22
8. Try and modify the number in the above URL and verify
  that the answer is correct