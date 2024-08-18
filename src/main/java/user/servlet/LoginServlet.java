package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.UserDAO;
import user.vo.UserVO;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String sessionId = SessionRepository.getSessionId(req.getCookies());
		
		if (Objects.isNull(sessionId) || !SessionRepository.containsSession(sessionId))
			req.getRequestDispatcher("/WEB-INF/views/login.html").forward(req, res);
		else
			res.sendRedirect("/after-login");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		UserVO userVO = new UserVO();

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		UserDAO userDAO = new UserDAO();
		userVO = userDAO.getLoginUser(id, pw);

		if (Objects.nonNull(userVO)) {
			HttpSession session = req.getSession(true);

			session.setAttribute("loginUser", userVO);
			String sessionId = session.getId();
			
			SessionRepository.addSession(sessionId, session);

			Cookie cookie = SessionRepository.getSessionCookie(sessionId);

			res.addCookie(cookie);

			res.sendRedirect("/after-login");

		} else {
			out.println("<html><head></head><body><h2>아이디나 비밀번호가 틀렸습니다.</h2>");
			out.println("<a href = '/login'>로그인 화면으로 이동</a>");
			out.println("</body></html>");
		}
	}
}
