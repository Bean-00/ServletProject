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

.space-between {
	margin-top: 10px;
	width: 240px;
	display: flex;
	justify-content: space-between;
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

	<%
	String sessionId = SessionRepository.getSessionId(request.getCookies());
	
	if (Objects.nonNull(sessionId) && SessionRepository.containsSession(sessionId))
		response.sendRedirect("/views/success-login.jsp");
	
	%>
	<form action="/views/submit-login.jsp" method="POST"
		style="display: flex; justify-content: center">
		<div class="box column-center">
			<h2>�α��� ȭ��</h2>
			<div class="space-between">
				���̵� <input name="id">
			</div>
			<div class="space-between">
				��й�ȣ <input name="pw" type="password">
			</div>
			<div style="width: 240px; display: flex; justify-content: center">
				<button style="width: 100px; margin-top: 15px;" type='submit'>�α���</button>
			</div>

			<div class="space-between" style="margin-top: 30px;">
				<a href='/views/register.jsp'>ȸ������</a>
				<div>|</div>
				<a href='/views/search-info.jsp'>������ã��</a>
			</div>

		</div>

	</form>



</body>
</html>