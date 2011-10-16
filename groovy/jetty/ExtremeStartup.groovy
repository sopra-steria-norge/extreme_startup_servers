#!/usr/bin/env groovy

@Grab('org.mortbay.jetty:jetty:6.1.22')

import javax.servlet.http.*;
import org.mortbay.jetty.*;
import org.mortbay.jetty.handler.*

Server server = new Server(8080);
def handler = [
  handle: { 
    target, request, HttpServletResponse response, int dispatch -> 
      response.setContentType 'text/plain'
      response.setCharacterEncoding 'UTF-8'
      response.writer.print "Hello groovy world!"
      response.flushBuffer()
    }
] 
server.handler = handler as AbstractHandler
server.start();
server.join();