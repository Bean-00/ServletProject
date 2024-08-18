package user.servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String sessionId = SessionRepository.getSessionId(req.getCookies());
		
		if (Objects.nonNull(sessionId) && SessionRepository.containsSession(sessionId)) {
			SessionRepository.removeSession(sessionId);
		}
		
		res.sendRedirect("/login");
	}

}
