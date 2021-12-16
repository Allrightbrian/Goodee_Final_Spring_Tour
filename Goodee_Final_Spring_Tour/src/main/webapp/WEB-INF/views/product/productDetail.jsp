<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form action="./productUpdate.do" method="post">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>상품코드</th>
						<th>상품이름</th>
						<th>가격</th>
						<th>등록일</th>
						<th>최근수정일</th>
						<th>상품 설명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="product_code" value="${productDetail.product_code}" hidden="hidden">${productDetail.product_code}</td>
						<td><input type="text" name="name" value="${productDetail.name}"></td>
						<td><input type="text" name="price" value="${productDetail.price}"></td>
						<td><input type="text" name="reg_date" value="${productDetail.reg_date}" hidden="hidden">${productDetail.reg_date}</td>
						<td><input type="text" name="update_date" value="${productDetail.update_date}" hidden="hidden">${productDetail.update_date}</td>
						<td><textarea cols="50" rows="10" name="description">${productDetail.description}</textarea></td>
					</tr>
				</tbody>
			</table>
			<button type="submit">수정</button>
			<input type="button" value="삭제" onclick="location.href='./productDelflag.do?product_code=${productDetail.product_code}'">
		</form>
	</div>
</body>
</html>