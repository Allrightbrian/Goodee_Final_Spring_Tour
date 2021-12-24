<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="./nav.jsp"%>
<title>프로필 보기</title>
</head>
<body>
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
								<a href="./wirtePostForm.do">새글 작성</a>
							</div>
						</div>
					</div>
				</div>
				<c:forEach var="post" items="${postList}">
					<div class="row">
						<div class="col-sm-3">
							<div class="well grid">
								<p>${post.post_title}</p>
								<a href="./detailPostSelect.do?postid=${post.post_id }"> <img
									src="${post.post_img_path}" height="100"
									width="100" alt="Avatar">
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