<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function listBtn(){
	location.href = "list";
}
</script>
</head>
<body>
<div align="center">
<h2>게시글 입력</h2>
<input type = "button" value = "글목록" onclick="listBtn()">
	<form action ="insert" method="post">
	<c:if test="${param.seq != null }">
	<input type = "hidden" id = "seq" name = "seq" value = "${param.seq }">
	<input type = "hidden" id = "groups" name = "groups" value = "${param.groups }">
	<input type = "hidden" id = "levels" name = "levels" value = "${param.levels }">
	<input type = "hidden" id = "steps" name = "steps" value = "${param.steps }">
	</c:if>
		<table>
			<tr>
				<td>제목</td>
				<c:if test="${param.seq == null }">
					<td><input type="text" id="title" name="title"></td>
				</c:if>
				<c:if test="${param.seq != null }">
					<td><input type="text" id="title" name="title" value="[답글]"></td>
				</c:if>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="content" name="content"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="writer" name="writer"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" id="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align = "center"><input type = "submit" value = "입력"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>