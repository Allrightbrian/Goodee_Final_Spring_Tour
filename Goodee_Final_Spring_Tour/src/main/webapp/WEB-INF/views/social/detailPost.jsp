<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./nav.jsp"%>
<title>포스트 상세보기</title>
</head>
<body>
<body>
	<div class="jumbotron">
		<div class="container text-center">
			<h1>${post.post_title }</h1>
			<p>조회수 : ${post.post_view_count }</p>
		</div>
	</div>

	<div class="container-fluid bg-3 text-center">
		<div>
			<p>${post.post_content}</p>
			<img src="${post.post_img_path}" class="img-responsive"
				style="width: 50%" alt="Image">
		</div>
	</div>
	<hr>
	<form action="postCommentInsert.do?postid=${post.post_id }"
		method="post">
		<div class="form-group center">
			<label for="comment">Comment:</label>
			<textarea class="form-control" cols="3" rows="3" id="comment"
				name="content"></textarea>
			<input class="btn-success" type="submit" value="댓글입력">
		</div>
	</form>
	<fieldset>
		<legend>댓글목록</legend>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>작성자</th>
						<th>내용</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="comment" items="${commentList}">
						<tr>
							<td>${comment.id }</td>
							<td>${comment.comment_content }</td>
							<td>${comment.comment_regdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</fieldset>
	<br>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>

</body>
</html>