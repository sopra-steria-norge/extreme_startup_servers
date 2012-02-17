import org.scalatra.ScalatraServlet


class ExtremeStartup extends ScalatraServlet {

    get("/") {
        "The server is running"
    }
    
}
