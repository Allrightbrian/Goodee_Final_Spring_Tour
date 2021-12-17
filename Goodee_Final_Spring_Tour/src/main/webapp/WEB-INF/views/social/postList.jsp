<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/onload.js"></script>
<style>

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Messages</a></li>
					<li><a href="postAllSelect.do">전체 포스트</a></li>
					<li><a href="themePostSelect.do">팔로우 테마 포스트</a></li>
					<li><a href="userPostSelect.do">팔로우 유저 포스트</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group input-group">
						<input type="text" class="form-control" placeholder="Search..">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							My Account</a></li>
					<li style="color: white;">${sessionScope.userid }님안녕하세요</li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container text-center">
		<div class="row">
			<div class="col-sm-3 well">
				<div class="well">
					<p>
						<a href="#">My Profile</a>
					</p>
				</div>
				<div class="well">
					<p>
						<a href="#">Interests</a>
					</p>
					<p>
						<span class="label label-default">News</span> <span
							class="label label-primary">W3Schools</span> <span
							class="label label-success">Labels</span> <span
							class="label label-info">Football</span> <span
							class="label label-warning">Gaming</span> <span
							class="label label-danger">Friends</span>
					</p>
				</div>
				<div class="alert alert-success fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<p>
						<strong>Ey!</strong>
					</p>
					People are looking at your profile. Find out who.
				</div>
				<c:forEach var="theme" items="${sessionScope.themeList}">
					<p>${theme.theme_name }
						: <a href="themeFollow.do?themeid=${theme.theme_id}">팔로우 하기</a> /
						<a href="themeUnFollow.do?themeid=${theme.theme_id}">언팔하기 </a>
					</p>
				</c:forEach>
			</div>
			<div class="col-sm-7">

				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default text-left">
							<div class="panel-body">
								<p contenteditable="true">Status: Feeling Blue</p>
								<button type="button" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-thumbs-up"></span> Like
								</button>
							</div>
						</div>
					</div>
				</div>
				<c:forEach var="post" items="${postList}">
					<div class="row">
						<div class="col-sm-3">
							<div class="well">
								<p>user : ${post.id}</p>
								팔로우하기 ! <a href="./userFollow.do?followingUserId=${post.id}">
									<img src="${post.post_img_path}" class="img-circle" height="55"
									width="55" alt="Avatar">
								</a> <br> 언팔하기 ! <a
									href="./userUnFollow.do?userUnFolowId=${post.id}"> <img
									src="${post.post_img_path}" class="img-circle" height="55"
									width="55" alt="Avatar">
								</a>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="well">
								<p>${post.post_title}</p>
								<a href="./detailPostSelect.do?postid=${post.post_id }"> <img
									src="${post.post_img_path}" class="img-circle" height="55"
									width="55" alt="Avatar">
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-sm-2 well">
				<div class="thumbnail">
					<p>Upcoming Events:</p>
					<p>
						<strong>Paris</strong>
					</p>
					<p>Fri. 27 November 2015</p>
					<button class="btn btn-primary">Info</button>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>