#!/usr/bin/env groovy

@Grab('groovy:groovy-xmlrpc:0.3')

import groovy.net.http.HTTPServer

s = new HTTPServer()
s.get = {inn, out, uri, version ->
  println uri
  out << "Content-Type: text/plain; charset=UTF-8\n"
  out << "\n"
  out << "Hello groovy world!"
}
s.startServer(new ServerSocket(1024))
println "Server started"