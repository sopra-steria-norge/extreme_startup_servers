Extreme Startup with Noir
=========================

Bodil Stokke (bodil@bodil.tv)

Usage
-----

We assume you have Leiningen installed, as well as a working SLIME
environment.

* First, run `lein deps` in your project directory to install the
  required dependencies.
* Load *src/extremestartup/server.clj* into your REPL, and run
  `(server/start 3000)`.
* Point your browser at <http://localhost:3000/> to make sure it works,
  and register the appropriate URL with the Extreme Startup server.
  Eg. if your LAN address is 192.168.0.5, the correct URL would be
  `http://192.168.0.5:3000/`.
* Load up *src/extremestartup/rules.clj* and extend the `dispatcher`
  function to your heart's content. Use the `testrule` macro to
  quickly unit test your dispatcher.

Alternately, if you'd like to run a separate production environment,
you can launch a production server by running `lein run` on the
command line. This server will be available on port 8080; make sure
you register the appropriate URL with the Extreme Startup server.

