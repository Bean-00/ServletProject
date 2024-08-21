<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="user.vo.UserVO"%>
<%@ page import="session.SessionRepository"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>

<html lang="ko">
<head>
<title>ȸ�� ����</title>
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

.form-input {
	display: flex;
	align-self: center;
	height: 25px;
	margin-left: 5px;
	margin-right: 5px;
}

.form-select {
	height: 25px;
	margin-left: 5px;
	margin-right: 5px;
}

.space-between {
	justify-content: space-between;
}
</style>
<body>
<%
String sessionId = SessionRepository.getSessionId(request.getCookies());
if (Objects.isNull(sessionId) || !SessionRepository.containsSession(sessionId)){
	response.sendRedirect("/views/login.jsp");
	return;
}
UserVO userVO = (UserVO) SessionRepository.getSession(sessionId).getAttribute("loginUser");

%>


	<div class="form-body">
		<div class="d-flex space-between">
			<h3>��������</h3>
			<h3>����</h3>
		</div>
		<form class="form" action="/views/submit-info.jsp" method="POST">
			<table>
				<tbody>
					<tr>
						<th><label for="id-form" class="form-label"><span
								class="star">*</span> ���̵�</label></th>
						<td><div style="margin-left: 5px"><%= userVO.getId() %></div></td>
						<th><label for="affiliation-form"
							class="form-label border-gray"><span class="star">*</span>
								��й�ȣ</label></th>
						<td><input class="form-input" type="text" name="pw"
							id="pw-form"></td>
					</tr>
					<tr>
						<th><label for="name-form"> <span class="star">*</span>
								�̸�
						</label></th>
						<td colspan="3"><input class="form-input" type="text"
							name="name" id="name-form" style="width: 169.6px" 
							value="<%= userVO.getName() %>"></td>
					</tr>
					<tr>
						<th><label for="gender-male"> <span class="star">*</span>
								����
						</label></th>
						<td colspan="3"><input type="radio" name="gender"
							id="gender-male" value="male"> �� <input type="radio"
							name="gender" id="gender-female" value="female"> ��</td>
					</tr>
					<tr>
						<th><label for="year-input" class="form-label"><span
								class="star">*</span> �������</label></th>
						<td colspan="3">
							<div class="d-flex">
								<input class="form-input" type="text" name="birth-year"
									id="year-input" style="width: 100px" value="<%= userVO.getBirthDateString().split("��")[0] %>"> �� <select
									class="form-select" name="birth-month" id="month"
									style="width: 50px">
									<%
									for (int i = 1; i <= 12; i++) {%>
										<option value="<%= i %>"><%= i %></option>
									<% } %>
			
								</select> �� <select class="form-select" name="birth-day" id="day"
									style="width: 50px">
									<%
									for (int i = 1; i <= 31; i++) {%>
										<option value="<%= i %>"><%= i %></option>
									<% } %>
								</select> �� <input type="radio" name="calendar" id="calendarS"
									value="solar"> <label for="calendarS">���</label> <input
									type="radio" name="calendar" id="calendarL" value="lunar">
								<label for="calendarL">����</label> (<input type="checkbox"
									name="isInter" id="calendarI" value="intercalation"> <label
									for="calendarI">����</label>)
							</div>
						</td>
					</tr>
					<tr>
						<th><label for="edu" class="form-label"><span
								class="star">*</span> �����з�</label></th>
						<td colspan="3"><select class="form-select"
							name="month-dropdown" id="edu" style="width: 150px">
								<option value="element-school">�ʵ��б� ����</option>
								<option value="mid-school">���б� ����</option>
								<option value="high-school">����б� ����</option>
								<option value="college">���б� ����</option>
						</select></td>
					</tr>
					<tr>
						<th><label for="job-select" class="form-label"><span
								class="star">*</span> ����</label></th>
						<td><select class="form-select" name="job" id="job-select">
								<option value="�鿣�� ������">�鿣�� ������</option>
								<option value="����Ʈ���� ������">����Ʈ���� ������</option>
						</select></td>
						<th><label for="affiliation-form"
							class="form-label border-gray">�Ҽ�</label></th>
						<td><input class="form-input" type="text" name="affiliation"
							id="affiliation-form"></td>
					</tr>
					<tr>
						<th><label for="married-n" class="form-label"><span
								class="star">*</span> ��ȥ����</label></th>
						<td><input type="radio" name="married" id="married-n"
							value="false"> ��ȥ <input type="radio" name="married"
							id="married-y" value="true"> ��ȥ</td>
						<th><label for="child" class="form-label border-gray">�ڳ��</label>
						</th>
						<td><select name="child-dropdown" id="child"
							class="form-select">
								<option value="1">1��</option>
								<option value="2">2��</option>
								<option value="3">3��</option>
						</select></td>
					</tr>
					<tr>
						<th rowspan="3"><label for="tel1"><span class="star">*</span>
								����ó</label></th>
						<td colspan="3">
							<div class="d-flex" style="height: 40px; margin-left: 5px;">
								<label for=tel1> ��ȭ��ȣ </label> <input type="tel"
									class="form-input" name="Tel" id="tel1" style="width: 50px">-
								<input type="tel" class="form-input" name="Tel" id="tel2"
									style="width: 50px">- <input type="tel"
									class="form-input" name="Tel" id="tel3" style="width: 50px">
								<input type="radio" class="tel-input" name="loc-radio"
									id="loc-home" value="home"> <label for="loc-home">��</label>
								<input type="radio" class="tel-input" name="loc-radio"
									id="loc-company" value="company"> <label
									for="loc-company">ȸ��</label>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="d-flex" style="height: 40px; margin-left: 16px;">
								<label for="pho1"> �޴��� </label> <input type="tel"
									class="form-input" name="first-pho-num" id="pho1"
									style="width: 50px" value="<%= userVO.getMobile().split("-")[0] %>">- <input type="tel"
									class="form-input" name="mid-pho-num" id="pho2"
									style="width: 50px" value="<%= userVO.getMobile().split("-")[1] %>">- <input type="tel"
									class="form-input" name="last-pho-num" id="pho3"
									style="width: 50px" value="<%= userVO.getMobile().split("-")[2] %>">
							</div>
						</td>
						<th><label for="agen-skt" class="form-label border-gray">�̵���Ż�</label>
						</th>
						<td><input type="radio" name="affiliation" id="agen-skt"
							value="skt"> <label for="agen-skt">SKT</label> <input
							type="radio" name="affiliation" id="agen-kt" value="ktf">
							<label for="agen-kt">KTF</label> <input type="radio"
							name="affiliation" id="agen-lg" value="lgt"> <label
							for="agen-lg">LGT</label></td>
					</tr>
					<tr>
						<td colspan="3">
							<div class="d-flex" style="height: 40px; margin-left: 5px;">
								<div class="d-flex">��ȭ��ȣ�� �޴�����ȣ 2���� �� �ϳ��� �ݵ�� �Է��ϼž� �մϴ�.</div>
							</div>
						</td>
					</tr>
					<tr>
						<th><label for="addr-input"><span class="star">*</span>������
								�ּ�</label></th>
						<td colspan="3">
							<div class="d-flex">
								<button name="pos" style="margin-left: 5px">����</button>
								<button name="pos" style="margin-left: 5px">����</button>
								<input type="text" name="address" id="addr-input"
									class="form-input" style="width: 600px" value="<%= userVO.getAddress() %>">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex" style="justify-content: center">
				<button name="updateInfo" type='submit'
					style="padding: 15px 20px; margin-top: 30px;">�� ���� �����ϱ�</button>
			</div>
			<a href='/views/success-login.jsp'>�α��� ȭ������ ���ư���</a>
		</form>

	</div>
	
</body>
</html>