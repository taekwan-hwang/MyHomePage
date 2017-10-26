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
		if(f.head.value==''){
			alert("제목은 빈 칸일 수 없습니다");
			f.head.focus();
			return;
		}
		if(f.content.value==''){
			f.content.value="내용이 없는 게시물입니다.";
		}
		f.submit();
	}
</script>
</head>
<body>
<form action="/post/append.do" method="post">
	<input name="head" type="text"/>
	<input name="content" type="text"/>
	<input type="button" value="등록" onclick="send(this.form)"/>
</form>

</body>
</html>