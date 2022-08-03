<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록</title>
</head>
<body>

<h2>글등록</h2>

<form action="insertBoard.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<td>제목</td>
			<td>글쓴이</td>
			<td>내용</td>
		</tr>
		<tr>
			<td><input type="text" name="title"></td>
			<td><input type="text" name="writer"></td>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><input type="submit" value="등록"></td>
		</tr>
	</table>
</form>

</body>
</html>