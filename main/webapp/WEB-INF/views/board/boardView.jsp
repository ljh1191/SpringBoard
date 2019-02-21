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
	function passcheckBtn(checknum) {
		$.ajax({
			type : "post",
			url : "passcheck",
			data :{"seq":$("#seq").val(),"password":$("#password").val()},
			success : function(data){
				if(data == 1){//비밀번호가 맞으면
					if(checknum == 1){//수정
						frm.action = "update";
						frm.method = "post";
		 				frm.submit();
		 				return false;
		 			}
		 			else if(checknum == 2){//삭제
		 				if (confirm("정말 삭제하시겠습니까?")) {
		 					location.href = "delete?seq=" + $("#seq").val();
		 					return false;
		 				}
		 			}
				}else{//비밀번호가 틀리면
					alert("비밀번호가 틀립니다.");
					return false;
				}
			}
		});
	}
	function listBtn(){
		location.href = "list";
	}
	function dapwriterBtn(){
		location.href = "insert?seq="+$("#seq").val()+"&groups="+$("#groups").val()+"&levels="+$("#levels").val()+"&steps="+$("#steps").val();
	}
	function replywriteBtn(){
		replyfrm.action = "replywrite"
		replyfrm.method = "post"
		replyfrm.submit();
	}
</script>
</head>
<body>
<div align="center">
	<h2>상세보기</h2>
	<input type = "button" value = "글목록" onclick="listBtn()">
	<form id = "frm">
		<input type = "hidden" id = "groups" name = "groups" value = "${dto.groups }">
		<input type = "hidden" id = "levels" name = "levels" value = "${dto.levels }">
		<input type = "hidden" id = "steps" name = "steps" value = "${dto.steps }">
		<table>
			<tr>
				<td>글번호</td>
				<td><input type="text" id="seq" name="seq" value="${dto.seq }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" value="${dto.title }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="content" name="content" value="${dto.content }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="writer" name="writer" value="${dto.writer }"></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${dto.hitcount }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" id="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="passcheckBtn(1)"> 
					<input type="button" value="삭제" onclick="passcheckBtn(2)">
				</td>
			</tr>
		</table>
		</form>
		<input type = "button" value="답글쓰기" onclick="dapwriterBtn()">
		<br>
		<table>
		<c:forEach items="${clist }" var="j">
		<tr>
			<td>${j.reply }</td>
			<td>${j.created }</td>
		</tr>
		</c:forEach>
		</table>
		
		<form id="replyfrm">
		<input type = "hidden" id = "boardnum" name = "boardnum" value = "${dto.seq }">
		
		<br>
		<textarea rows="5" cols="40" id="reply" name="reply"></textarea>
		<input type = "button" value="댓글쓰기" onclick="replywriteBtn()">
	</form>
</div>
</body>
</html>