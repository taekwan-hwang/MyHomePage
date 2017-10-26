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
	function download(filename) {
		location.href = "${pageContext.request.contextPath}/download.do?dir=/upload/&filename="
				+ filename;
	}
	function del(idx, filename) {
		var userPwd = window.prompt("비밀번호 입력");
		$.ajax({
			url : "checkPwd.do",
			data : "idx=" + idx + "&userPwd=" + userPwd,
			method : "POST",
			success : function(data) {
				if (data == 'correct') {
					location.href = "delete.do?idx=" + idx
							+ "&dir=/upload/&filename=" + filename;
				} else {
					alert("비밀번호 오류");
				}
			}
		});
	}
</script>
</head>
<body>
	<div id="main_box">
		<h1 align="center">::Posts::</h1>
		<div align="center">
			<input type="button" id="button_add" value="업로드"
				onclick="location.href='/post/insert_form.do'" />
		</div>
		<div id="photo_box">
			<c:if test="${postList.size()==0 }">
				<div align="center">등록된 게시물이 없습니다.</div>
			</c:if>
			<c:forEach var="vo" items="${postList }">
				<div>
					<div>${vo.idx }
						<a href="/post/view.do?head=${vo.head }">${vo.head }</a>
					</div>
					<div align="center">
						<input type="button" value="download"
							onclick="download('${vo.head}')"> <input
							type="button" value="delete"
							onclick="del('${vo.idx}','${vo.head }')">
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>