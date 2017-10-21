<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
	function send(f){
		f.submit();
	}
	</script>
</head>
<body>
	<h1>signup page</h1>
	<form action="/login/regist.do" method="post">
		<table border="1">
			<caption>::sign up::</caption>
			<tr>
				<th>id</th>
				<td><input type='text' name='id'></td>
			</tr>
			<tr>
				<th>password</th>
				<td><input type="text" name="pwd"></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type='text' name='name'></td>
			</tr>
			<tr>
				<td colspan="2"><input type='button' value="signup"
					onclick='send(this.form)' /> <input type="reset" value="cancel" /></td>
			</tr>
		</table>
	</form>
</body>
</html>