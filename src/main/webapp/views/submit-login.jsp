<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="session.SessionRepository"%>
<%@ page import="java.util.*"%>
<%@ page import="user.vo.UserVO"%>
<%@ page import="user.dao.UserDAO"%>
<%
UserVO userVO = new UserVO();

String id = request.getParameter("id");
String pw = request.getParameter("pw");

UserDAO userDAO = new UserDAO();
userVO = userDAO.getLoginUser(id, pw);

if (Objects.nonNull(userVO)) {

	session.setAttribute("loginUser", userVO);
	String sessionId = session.getId();
	
	SessionRepository.addSession(sessionId, session);

	Cookie cookie = SessionRepository.getSessionCookie(sessionId);

	response.addCookie(cookie);

	response.sendRedirect("/views/success-login.jsp");

} else {
	response.sendRedirect("/views/fail-login.jsp");
}
	
%>