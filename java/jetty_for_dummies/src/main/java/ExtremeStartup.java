import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ExtremeStartup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("A request has arrived");
        resp.getWriter().write(answer(req.getParameter("q")));
    }
        
    String answer(String parameter) {
        if (parameter == null)
            return "team name";
        
        Matcher additionMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(parameter);
        if (additionMatcher.matches()) {
            return String.valueOf(Integer.parseInt(additionMatcher.group(1))
                    + Integer.parseInt(additionMatcher.group(2)));
        }   
    
        return "team name";
    }

    
    public static void main(String[] args) throws Exception {
        Server server = new Server(1337);
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(new ServletHolder(new ExtremeStartup()), "/*");
        server.setHandler(context);
        server.start();
    }
}
