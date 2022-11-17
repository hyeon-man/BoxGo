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
		<h3>제품 목록</h3>
		<div>
			<form>
				<div>
					<select name="search">
						<option value="1">제품번호</option>
						<option value="2">제품명</option>
						<option value="3">바코드</option>
					</select>
				</div>
				<div>
					<input type="text" name="keyword">
				</div>
				<div>
					<button>검색</button>
				</div>
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<td>제품번호</td>
						<td>제품명</td>
						<td>바코드</td>
						<td>관리</td>
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">검색 된 데이터가 없습니다</td>
						</tr>
					</c:if>			
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.barcode}</td>
							<td><a href="update/${item.id}">변경</a> <a href="delete/${item.id}">삭제</a></td>
						</tr>
					</c:forEach>	
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="5">
							<div>
								<div><a href="?page=1&${pager.query}">처음</a></div>
								<div><a href="?page=${pager.prev}&${pager.query}">이전</a></div>
								
								<c:forEach var="page" items="${pager.list}">
									<div><a href="?page=${page}&${pager.query}">${page}</a></div>
								</c:forEach>
										
								<div><a href="?page=${pager.next}&${pager.query}">다음</a></div>
								<div><a href="?page=${pager.last}&${pager.query}">마지막</a></div>						
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div>
			<a href="add">등록</a>
		</div>		
		<div>
			<a href="/">처음으로</a>
		</div>
	</div>
</body>
</html>