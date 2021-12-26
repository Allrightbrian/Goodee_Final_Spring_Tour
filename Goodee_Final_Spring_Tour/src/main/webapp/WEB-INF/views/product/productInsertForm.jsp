<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가</title>
<%@ include file="../common/topMenu.jsp" %>
</head>
<body>
<div class="container">
		<form action="./productInsert.do" method="post">
			<table class="table">
				<thead>
					<tr>
						<th>상품이름</th>
						<th>가격</th>
						<th>상품 설명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="name" placeholder="상품의 이름을 입력해주세요" required></td>
						<td><input type="text" name="price" placeholder="상품의 가격을 입력해주세요" required></td>
						<td><textarea cols="50" rows="10" name="description" placeholder="상품의 설명을 입력해주세요" required></textarea></td>
					</tr>
				</tbody>
			</table>
			<button type="submit">등록</button>
		</form>
		<div>
			<input type="button" class="btn btn-warning btn-block btn-lg" value="돌아가기" onclick="history.back(-1)">
		</div>
	</div>
</body>
</html>