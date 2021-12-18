<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./js/onload.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>
</head>
<body>
<body>
<div id="header"></div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Portfolio</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Gallery</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

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