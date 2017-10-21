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
</head>
<body>
	<h1>메인페이지</h1>
	<c:if test="${sessionScope.user==null }">
		<input type="button" value="login"
			onclick="location.href='/login/loginform.do'" />
		<input type="button" value="sign up"
			onclick="location.href='/login/signupform.do'"/>
	</c:if>
	<c:if test="${sessionScope.user!=null }">
		<ul>
			<li>${sessionScope.user.name } hi</li>
		</ul>
		<input type="button" value="logout"
			onclick="location.href='/login/logout.do'" />
			<input type="button" value="post" onclick="location.href='/post/list.do'"/>
	</c:if>
</body>
</html>