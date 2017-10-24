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
	function send(f) {
		
		if(f.id.value==''){
			alert('id is not null');
			f.id.focus();
			return;
		}
		if(f.pwd.value==''){
			alert('pwd is not null');
			f.pwd.focus();
			return;
		}
		if(f.name.value==''){
			alert('name is not null');
			f.name.focus();
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
	<h1>signup page</h1>
	<form action="/login/signup.do" method="post">
		<input type='hidden' name="save" value='n' />
		<table border="1">
			<caption>::sign up page::</caption>
			<tr>
				<th>id</th>
				<td><input name="id" /></td>
			</tr>
			<tr>
				<th>password</th>
				<td><input type="password" name="pwd">
			</tr>
			<th>name</th>
			<td><input name="name"/>
			<tr>
				<td colspan="2"><input type='button' value="submit"
					onclick='send(this.form)' /> <input type="reset" value="cancel" /></td>
			</tr>
		</table>
	</form>
</body>
</html>