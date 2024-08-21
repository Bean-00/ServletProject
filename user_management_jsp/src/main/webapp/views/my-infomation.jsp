<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<html lang="ko">
<head>
<title>내 정보 보기</title>
<meta charset="EUC-KR">
</head>
<style>
* {
	box-sizing: border-box;
}

.form-body {
	width: 1000px;
	margin: auto;
}

.form {
	width: 1000px;
}

.form table {
	width: 100%;
}

.star {
	color: #c21818;
}

.form table, .form th, .form td {
	border: 1px solid #ccc;
	border-collapse: collapse;
}

.d-flex {
	display: flex;
	align-items: center;
}

.form th {
	width: 200px;
	height: 40px;
	padding: 5px;
}

.space-between {
	justify-content: space-between;
}

.margin5px {
	margin-left: 5px;
}

</style>
<body>
<%@ page import = "user.vo.UserVO"%>
<%@ page import = "user.dao.UserDAO"%>
<%@ page import = "java.util.*" %>
<%
String name = request.getParameter("name");

UserVO userVO = new UserVO();
UserDAO userDAO = new UserDAO();

userVO = userDAO.getUserInfo(name);

if (Objects.isNull(userVO)){
	response.sendRedirect("/views/no-result.jsp");
	return;
}

%>
	<div class="form-body">
		<div class="d-flex space-between">
			<h2>내 정보 보기</h2>
		</div>
		<form class="form" action="/register" method="POST">
			<table>
				<tbody>
					<tr>
						<th><label for="name-form"> <span class="star">*</span>
								이름
						</label></th>
						<td colspan="3"><span class="margin5px"><%=userVO.getName() %></span></td>
					</tr>
					<tr>
						<th><label for="gender-male"> <span class="star">*</span>
								성별
						</label></th>
						<td colspan="3"><span class="margin5px"><%= userVO.getGender() %></span></td>
					</tr>
					<tr>
						<th><label for="year-input" class="form-label"><span
								class="star">*</span> 생년월일</label></th>
						<td colspan="3">
							<div class="d-flex">
								<span class="margin5px"><%= userVO.getBirthDateString() %></span>
							</div>
						</td>
					</tr>
					<tr>
						<th><label for="job-select" class="form-label"><span
								class="star">*</span> 직업</label></th>
						<td><span class="margin5px"><%= userVO.getJob() %></span></td>
					</tr>
					<tr>
						<th rowspan="2"><label for="tel1"><span class="star">*</span>
								연락처</label></th>
					</tr>
					<tr>
						<td>
							<div class="margin5px">
								 <span><%= userVO.getMobile() %></span>
							</div>
						</td>
					</tr>
					<tr>
						<th><label for="addr-input"><span class="star">*</span>거주지
								주소</label></th>
						<td colspan="3">
							<div class="margin5px">
								<span><%= userVO.getAddress() %></span>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex" style="justify-content: center; margin-top: 30px">
				<a href='/views/login.jsp'>로그인 화면으로 이동하기</a>
			</div>
		</form>

	</div>
</body>
</html>