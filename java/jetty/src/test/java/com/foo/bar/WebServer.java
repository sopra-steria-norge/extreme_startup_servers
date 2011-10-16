package com.foo.bar;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer {
    
    public static void main(String[] args) throws Exception {
        Server server = new Server(8088);
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { 
                new WebAppContext("src/main/webapp", "/"),
        });
        server.setHandler(handlers);
        server.start();
    }

}
