<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
function searchBtn(){
	location.href = "list?field="+$("#field").val()+"&word="+$("#word").val();
}
function writeBtn(){
	location.href = "insert";
}
function pagingBtn(pageNum) {
	location.href = "list?pageNum=" + pageNum+"&field="+$("#field").val()+"&word="+$("#word").val();
}
</script>
</head>
<body>
<div align="center">
<h2>게시글목록</h2>
	<input type = "button" value = "글쓰기" onclick = "writeBtn()">
	<table>
		<tr>
			<td align="right" colspan="5">게시글수 : ${count }</td>
		</tr>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var = "i">
		<tr>
			<td>${i.seq }</td>
				
			<td>
			<c:if test="${i.levels>0}">
			 <img src="resources/level.gif" width="${i.levels*5 }" height="16">
			 <img src="resources/re.gif">
			</c:if>
			<a href = "view?seq=${i.seq }">${i.title }</a></td>
			<td>${i.content }</td>
			<td>${i.writer }</td>
			<td>${i.hitcount }</td>
			<td>${i.regdate }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				${pageHtml}
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<select id = "field" name = "field">
					<option value="title">제목</option>
					<option value="writer">작성자</option>
					<option value="content">내용</option>
				</select>
				<input type = "text" id = "word" name = "word">
				<input type = "button" value = "검색" onclick="searchBtn()">
			</td>
		</tr>
	</table>
</div>
</body>
</html>