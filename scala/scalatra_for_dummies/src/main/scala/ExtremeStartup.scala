import org.scalatra.ScalatraServlet


class ExtremeStartup extends ScalatraServlet {

    def answer(question:String):String = {
        val PlusExpression = """.*what is the sum of (\d+) and (\d+)""".r
        val SantaClauseExpression = """.*what's santa clause's real name""".r
        question match {
            case PlusExpression(x,y) =>
                return (Integer.parseInt(x) + Integer.parseInt(y)).toString
            case SantaClauseExpression() => // <-- Parens are important here!
                return "Kris Kringle"
            case _ => 
                System.out.println("Unrecognized question: " + question)
                return "scala team"
        }
    }

    get("/") {
      params("q") match {
        case q:String => 
            System.out.println("A request has arrived")
            answer(q)
        case _ => pass()
      }
    }
    
}
