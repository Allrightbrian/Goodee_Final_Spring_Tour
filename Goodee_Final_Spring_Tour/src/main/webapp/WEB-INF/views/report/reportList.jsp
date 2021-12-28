<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>불편사항 신고하기 - 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>불편사항/비매너 유저 신고</h2>
  <button type="button" onclick="script:location.href='./writeReportForm.do'">신고 글 작성</button>
  <table class="table table-hover">
    <thead>
      <tr>
        <th></th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="report" items="${requestScope.reportList}">
      <tr>
      	<td>${report.report_num }</td>
      	<td>
      	<c:choose>
      		<c:when test="${(report.secretflag eq 'N') or (sessionScope.member.manager eq 'Y') }">
      			<a href="./selectOneReport.do?report_num=${report.report_num }">${report.title}</a>
      		</c:when>
      		<c:otherwise>
      			<a href="./selectOneReport.do?report_num=${report.report_num }">이 글은 비밀글로 작성자만 볼 수 있습니다.</a>
      		</c:otherwise>
      	</c:choose>
      	</td>
      	<td>${report.userid}</td>
        <td>${report.regdate}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
 
  <ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">&lsaquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&rsaquo;</a></li>
    <li><a href="#">&raquo;</a></li>
    
  </ul>
</div>
</body>
</html>