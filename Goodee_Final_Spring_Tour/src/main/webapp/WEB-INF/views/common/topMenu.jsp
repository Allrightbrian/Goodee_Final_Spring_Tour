<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Spring Tour</a>
    </div>
    <ul class="nav navbar-nav navbar-left">
      <li><a href="./main.do">게시판</a></li>
      
      <c:if test="${sessionScope.memberInfo.managerYN eq 'N'}">
	      <li><a href="./myBookTourList.do">myBookTour</a></li>  
	      <li><a href="./confirmPw.do">개인정보수정</a></li>  
      </c:if>
      
      <c:if test="${sessionScope.memberInfo.managerYN eq 'Y'}">
	      <li><a href="./memberListMAV.do">회원관리</a></li>
	      <li><a href="./productList.do">결제상품관리</a></li>
      </c:if>
      
	  <li><a href="./paymentList.do">결제내역조회</a></li>  
      
    </ul>
    
     <ul class="nav navbar-nav navbar-right">
      <li>
      	<a href="#">
      		${sessionScope.memberInfo.memberId}님 환영합니다. (${(sessionScope.memberInfo.managerYN == 'N')?'사용자':'관리자'})
      	</a>
      </li>
      <li><a href="./logout.do"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
    </ul>
  </div>
</nav>
</body>
</html>




