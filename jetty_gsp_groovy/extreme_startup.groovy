#!/usr/bin/env groovy

//http://groovyconsole.appspot.com/script/2

@Grab('org.mortbay.jetty:jetty-embedded:6.1.26')
import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.*
import groovy.servlet.*

def startJetty() {
	def jetty = new Server(9090)

	def context = new Context(jetty, '/', Context.SESSIONS)  // Allow sessions.
	context.resourceBase = '.'  // Look in current dir for Groovy scripts.
	context.addServlet(TemplateServlet, '*.gsp')  // All files ending with .gsp will be served.
//	context.setAttribute('version', '1.0')  // Set an context attribute.

	jetty.start()
}

println "Starting Jetty, press Ctrl+C to stop."
startJetty()
