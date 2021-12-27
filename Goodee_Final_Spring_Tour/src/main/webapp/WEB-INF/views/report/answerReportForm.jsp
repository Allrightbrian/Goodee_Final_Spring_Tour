<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/writeAnswerReport.js"></script>
</head>
<body>
<div class="container">
  <h2>불편사항/비매너 유저 신고 답변</h2>
  <form class="form-horizontal" action="./answerReport.do" method="post">
  <input type="hidden" name="report_num" value="${requestScope.report.report_num}">
  <div class="form-group">
    <label class="control-label col-sm-2" for="title">제목</label>
    <div class="col-sm-10">
      <input type="hidden" name="title" value="&nbsp;&nbsp;[RE]${requestScope.report.title}">
      <input type="text" class="form-control" id="title" name="title" value="[RE]${requestScope.report.title}" disabled="disabled">
      <input type="hidden" name="secretflag" value="${requestScope.report.secretflag}">
      <label> <input type="checkbox" id="secretflag" disabled="disabled"> 비밀글</label>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="content">내용</label>
    <div class="col-sm-10">
      <textarea rows="8" cols="100" style="resize: none" class="form-control" id="content" name="content"></textarea>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" class="btn btn-default" value="작성 완료" onclick="return answerReport();">
    </div>
  </div>
  </form>
</div>
</body>
</html>