import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExtremeStartup extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String q = req.getParameter("q");
		System.out.println("request:" + q);
		resp.getWriter().write(answer(q));
	}

	String answer(String parameter) {
		if (parameter == null)
			return "myteam";
		Matcher additionMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(parameter);
		if (additionMatcher.matches()) {
			return String.valueOf(Integer.parseInt(additionMatcher.group(1))
					+ Integer.parseInt(additionMatcher.group(2)));
		}
		return "myteam";
	}

}
