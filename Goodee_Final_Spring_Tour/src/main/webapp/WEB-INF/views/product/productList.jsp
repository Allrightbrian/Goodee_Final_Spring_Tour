<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 전체조회</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품코드</th>
					<th>상품이름</th>
					<th>가격</th>
					<th>등록일</th>
					<th>최근수정일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${requestScope.productList}">
					<tr>
						<td>${product.product_code}</td>
						<td><a href="./productDetail.do?product_code=${product.product_code}">${product.name}</a></td>
						<td>${product.price}</td>
						<td>${product.reg_date}</td>
						<td>${product.update_date}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<button onclick="location.href='./productInsertForm.do'">상품 등록</button>
	</div>

</body>
</html>