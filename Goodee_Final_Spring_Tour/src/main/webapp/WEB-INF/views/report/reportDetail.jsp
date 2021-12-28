<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>불편사항/비매너 유저 신고</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/updateReport.js"></script>
</head>
<body>
<div class="container">
<h2>불편사항 신고 게시글 보기</h2>
<c:if test="${sessionScope.member.id != requestScope.report.userid }">
	<table class="table table-hover">
		<thead>
		</thead>
		<tbody>
		  <tr>
		  	<th>제목</th>
		    <td>${requestScope.report.title}
		    	<input type="hidden" name="secretflag" value="${requestScope.report.secretflag}">          
      				<label> <input type="checkbox" id="secretflag" disabled="disabled"> 비밀글</label>
		    </td>
		  </tr>
		  <tr>
		  	<th>작성날짜</th>
		    <td>${requestScope.report.regdate}</td>
		  </tr>
		  <tr>
		  	<th>작성자</th>
		    <td>${requestScope.report.userid}</td>
		  </tr>
		  <tr>
		    <th>내용</th>
		    <td><textarea rows="5" cols="100" disabled="disabled" style="resize: none">${requestScope.report.content}</textarea></td>
		  </tr>
		 </tbody>
	</table>
	<c:if test="${sessionScope.member.manager eq 'Y' or sessionScope.member.id eq requestScope.reportRef.userid}">
		<input type="button" value="답글작성" onclick="location.href='./answerReportForm.do?report_num=${requestScope.report.report_num}'">		
	</c:if>
</c:if>
    <c:if test="${sessionScope.member.id eq requestScope.report.userid }">
    	<form>
	    <table class="table table-hover">
			<thead>
			</thead>
			<tbody>
			  <tr>
			  	<th>제목</th>
			    <td>
			    	<input type="text" name="title" value="${requestScope.report.title}"> 
			    	<input type="hidden" name="secretflag" value="${requestScope.report.secretflag}">
      				<label> <input type="checkbox" id="secretflag"> 비밀글</label>
			    </td>
			    
			  </tr>
			  <tr>
			  	<th>작성날짜</th>
			    <td>${requestScope.report.regdate}</td>
			  </tr>
			  <tr>
			  	<th>작성자</th>
			    <td>${requestScope.report.userid}</td>
			  </tr>
			  <tr>
			    <th>내용</th>
			    <td><textarea rows="5" cols="100" name="content" style="resize: none">${requestScope.report.content}</textarea> 
			    	<input type="hidden" value="${requestScope.report.content}" id="originContent"></td>
			  </tr>
			 </tbody>
		</table>
		<input type="button" value="삭제하기" onclick="location.href='./deleteReport.do?report_num=${requestScope.report.report_num}'">
		<input type="button" value="수정하기" onclick="updateReport(${requestScope.report.report_num})">
		<c:if test="${sessionScope.member.manager eq 'Y' or sessionScope.member.id eq requestScope.reportRef.userid}">
			<input type="button" value="답글작성" onclick="location.href='./answerReportForm.do?report_num=${requestScope.report.report_num}'">		
		</c:if>
		</form>
    </c:if>
</div>
</body>
</html>