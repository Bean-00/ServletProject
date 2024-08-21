<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="session.SessionRepository"%>
<!DOCTYPE html>
<html>
<head></head>
<body>

	<%@ page import="user.vo.UserVO"%>
	<%@ page import="user.dao.UserDAO"%>
	<%@ page import="java.util.*"%>
	<%
	
	String sessionId = SessionRepository.getSessionId(request.getCookies());
	if (Objects.isNull(sessionId) || !SessionRepository.containsSession(sessionId)){
		response.sendRedirect("/views/login.jsp");
		return;
	}
	UserVO userVO = (UserVO) SessionRepository.getSession(sessionId).getAttribute("loginUser");

	userVO.setName(request.getParameter("name"));
	userVO.setGender(request.getParameter("gender"));
	userVO.setBirthDate(request.getParameter("birth-year"), request.getParameter("birth-month"),
			request.getParameter("birth-day"));
	userVO.setJob(request.getParameter("job"));
	userVO.setMobile(request.getParameter("first-pho-num"), request.getParameter("mid-pho-num"),
			request.getParameter("last-pho-num"));
	userVO.setAddress(request.getParameter("address"));
	userVO.setPw(request.getParameter("pw"));

	if (userVO.checkValidation()) {
		UserDAO userDAO = new UserDAO();
		userDAO.updateuser(userVO);
	} else {
		response.sendRedirect("/views/fail-update.jsp");
	}
	%>
	<h2><%=userVO.getName()%>님 정보 수정이 완료되었습니다.
	</h2>
	<a href='/views/login.jsp'>로그인 화면으로 이동하기</a>
</body>
</html>