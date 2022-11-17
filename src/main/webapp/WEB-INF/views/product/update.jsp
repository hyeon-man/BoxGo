<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<h3>용어 변경</h3>
		<div>
			<form method="post">
				<div>
					<label>용어번호:</label>${item.id}
				</div>
				
				<div>
					<label>용어:</label>
					<input type="text" name="name" value="${item.name}">
				</div>
								
				<div>
					<button>변경</button>
					<a href="../list"><button type="button">목록</button></a>
				</div>			
			</form>
		</div>
	</div>
</body>
</html>
