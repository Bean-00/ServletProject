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

public class AfterLoginServlet extends HttpServlet {
	
	public AfterLoginServlet() {
		
	}
	

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		
		String sessionId = SessionRepository.getSessionId(req.getCookies());
		
		
		if (Objects.isNull(sessionId) || !SessionRepository.containsSession(sessionId)) {
			res.sendRedirect("/login");
			return;
		}
		
		UserVO userVO = (UserVO) SessionRepository.getSession(sessionId).getAttribute("loginUser");
		
		out.println(String.format("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"EUC-KR\">\r\n"
				+ "<title>내 정보 찾기</title>\r\n"
				+ "</head>\r\n"
				+ "<style>\r\n"
				+ ".box {\r\n"
				+ "	margin-top: 100px;\r\n"
				+ "	width: 300px;\r\n"
				+ "	height: 190px;\r\n"
				+ "	border-color: #ccc;\r\n"
				+ "	border-style: solid;\r\n"
				+ "	border-width: 3px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".center {\r\n"
				+ "	margin-top: 10px;\r\n"
				+ "	width: 240px;\r\n"
				+ "	display: flex;\r\n"
				+ "	justify-content: center;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".column-center {\r\n"
				+ "	display: flex;\r\n"
				+ "	flex-direction: column;\r\n"
				+ "	align-items: center;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "<body>\r\n"
				+ "	<form action=\"/login\" method=\"POST\"\r\n"
				+ "		style=\"display: flex; justify-content: center\">\r\n"
				+ "		<div class=\"box column-center\">\r\n"
				+ "			<h2>로그인 화면</h2>\r\n"
				+ "			<div>%s님 환영합니다.</div>\r\n"
				+ "			<div class=\"center\" style=\"margin-top: 30px;\">\r\n"
				+ "				<a href='/my-infomation?name=%s'>내정보 조회</a>\r\n"
				+ "				<a href='/logout'>로그아웃</a>\r\n"
				+ "			</div>\r\n"
				+ "		</div>\r\n"
				+ "\r\n"
				+ "	</form>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>", userVO.getName(), userVO.getName()));
		
		
	}
}
