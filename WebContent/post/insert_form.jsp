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
	<table>
	<tr>
		<td class="list_articles">
			<table>
				<tbody>
					<tr>
						<td width="15%"><font class="write_title">제목</font></td>
						<td width="85%"><input type="text" id="write_subject" class="write_subject"/></td>
					</tr>
					<tr>
						<td width="15%"><font class="write_title">작성자</font></td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea id="write_content" class="write_content"></textarea>
						</td>
					</tr>
				</tbody>
			</table>		
		</td>
	</tr>
	<tr>
		<td class="list_articles">
			<table>
				<tbody>
					<tr>
						<td align="right">
							<font class="common_but">글쓰기</font> | <font class="common_but">목록</font>
						</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
</table>
</form>

</body>
</html>