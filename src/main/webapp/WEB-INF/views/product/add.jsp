<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<h3>제품 등록</h3>
		<div>
			<form method="post">
				<div>
					<h2>기본 정보</h2>
				</div>
				<div>
					<label>제품명:</label>
					<input type="text" name="name">
				</div>
				
				<div>
					<label>바코드:</label>
					<input type="text" name="barcode"><button type="button">자동생성</button>
				</div>
				
				<hr>
				
				<div>
					<label>카테고리:</label>
					<input type="text" name="category">
					<select id="category">
						<option>직접 입력</option>
						<c:forEach var="item" items="${categorys}">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<div>
					<label>브랜드:</label>
					<input type="text" name="brand">
					<select id="brand">
						<option>직접 입력</option>
						<c:forEach var="item" items="${brands}">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<div>
					<label>사이즈:</label>
					<input type="text" name="size">
					<select id="size">
						<option>직접 입력</option>
						<c:forEach var="item" items="${sizes}">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</div>
				
				<div>
					<label>컬러:</label>
					<input type="text" name="color">
					<select id="color">
						<option>직접 입력</option>
						<c:forEach var="item" items="${color}">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</div>
								
				<div>
					<button>등록</button>
					<a href="list"><button type="button">목록</button></a>
				</div>			
			</form>
		</div>
	</div>
</body>
</html>
