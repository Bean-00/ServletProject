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
	height: 150px;
	border-color: #ccc;
	border-style: solid;
	border-width: 3px;
}

.column-center {
	display: flex;
	flex-direction: column;
	align-items: center;
}
</style>
<body>
	<form style="display: flex; justify-content: center" action="/views/my-infomation.jsp">
		<div class="box column-center">
			<h2>�̸��� �Է����ּ���</h2>
			<div>
				<input name = "name">
				<button type='submit'>��ȸ</button>
			</div>
			<a href='/views/login' style="margin-top: 10px">�α��� ȭ������ ���ư���</a>
		</div>
	</form>



</body>
</html>