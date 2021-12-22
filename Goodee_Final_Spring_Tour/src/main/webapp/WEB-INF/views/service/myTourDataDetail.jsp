<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<title>Insert title here</title>
</head>
<body>
	
<div class="bg-1">
  <div class="container">
  	<fmt:parseDate value="${modifiedtime}" var="DATE" pattern="yyyyMMddHHmmss"/>
  	<fmt:formatDate var="resultRegDt" value="${DATE}" pattern="yyyy-MM-dd HH:mm:ss"/>
    <h3 class="text-center">${TourData.title}</h3>
    <ul class="list-group">
      <li class="list-group-item">주소:&nbsp;${TourData.addr1}&nbsp;${TourData.addr2}</li>
      
      <li class="list-group-item">ContentId:&nbsp;${TourData.contentid}</li> 
      <li class="list-group-item">수정일자:&nbsp;${resultRegDt}</li> 
    </ul>
    
    <div class="row text-center">
      <div class="col-sm-6">
        <div class="thumbnail">
          <img src="${TourData.firstimage}" alt="이미지가 없습니다." width="500px" height="500px">
        </div>
      </div>
       <div class="col-sm-6">
        <div class="thumbnail" style="width:500px; height:500px">
        	${TourData.overview}
        </div>
      </div>
    </div>
  </div>
  </div>
</body>
</html>