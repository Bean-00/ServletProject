<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ���� ã��</title>
</head>
<style>
.box {
	margin-top: 100px;
	width: 300px;
	height: 190px;
	border-color: #ccc;
	border-style: solid;
	border-width: 3px;
}

.center {
	margin-top: 10px;
	width: 240px;
	display: flex;
	justify-content: center;
}

.column-center {
	display: flex;
	flex-direction: column;
	align-items: center;
}
</style>
<body>
	<%@ page import="session.SessionRepository"%>
	<%@ page import="java.util.*"%>
	<%@ page import="user.vo.UserVO" %>
	<%
String sessionId = SessionRepository.getSessionId(request.getCookies());


if (Objects.isNull(sessionId) || !SessionRepository.containsSession(sessionId)) {
	response.sendRedirect("/login.jsp");
	return;
}

UserVO userVO = (UserVO) SessionRepository.getSession(sessionId).getAttribute("loginUser");
%>
	<form action="/login" method="POST"
		style="display: flex; justify-content: center">
		<div class="box column-center">
			<h2>�α��� ȭ��</h2>
			<div><%= userVO.getName() %>�� ȯ���մϴ�.</div>
			<div class="center" style="margin-top: 30px;">
				<a href='/views/my-infomation.jsp?name=<%= userVO.getName() %>'
					style="margin-right:10px">������ ��ȸ</a>
				<a href='/views/logout.jsp'>�α׾ƿ�</a>
			</div>
		</div>

	</form>



</body>
</html>