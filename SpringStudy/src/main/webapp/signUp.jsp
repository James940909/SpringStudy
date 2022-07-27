<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<h1>회원가입</h1>
<hr>
<form action="signUp.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange">아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td bgcolor="orange">비밀번호</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td bgcolor="orange">이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td bgcolor="orange">E-mail</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td bgcolor="orange">전화번호</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td bgcolor="orange">주소</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="회원가입"/>
			</td>
		</tr>
	</table>
</form>
<hr>

</body>
</html>