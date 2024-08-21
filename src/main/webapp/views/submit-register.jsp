<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head></head>
<body>

	<%@ page import="user.vo.UserVO"%>
	<%@ page import="user.dao.UserDAO"%>
	<%@ page import="java.util.*"%>
	<% UserVO userVO = new UserVO();
	
	userVO.setName(request.getParameter("name"));
	userVO.setGender(request.getParameter("gender"));
	userVO.setBirthDate(request.getParameter("birth-year"), request.getParameter("birth-month"), request.getParameter("birth-day"));
	userVO.setJob(request.getParameter("job"));
	userVO.setMobile(request.getParameter("first-pho-num"), request.getParameter("mid-pho-num"), request.getParameter("last-pho-num"));
	userVO.setAddress(request.getParameter("address"));
	userVO.setId(request.getParameter("id"));
	userVO.setPw(request.getParameter("pw")); 
	
	if (userVO.checkValidation()) {
		UserDAO userDAO = new UserDAO();
		userDAO.adduser(userVO);
	} else {
		response.sendRedirect("/views/fail-register.jsp");	
	} 
		
	%>
	<h2><%= userVO.getName() %>님 회원 가입이 완료되었습니다.
	</h2>
</body>
</html>