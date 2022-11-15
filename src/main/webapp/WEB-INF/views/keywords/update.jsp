<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<div>
    <div>
        <h1>도메인 정보 변경</h1>
    </div>
    <div>
        <form method="post">
            <div>
                <label>도메인 번호 :</label>
                <input value="${item.id}" readonly>
            </div>
            <div>
                <label>도메인명:</label>
                <input name="name" type="text" value="${item.name}">
            </div>

            <div>
                <button>변경</button>
            </div>
        </form>
    </div>
    <div>
        <a href="/domain/list">취소</a>
    </div>
</div>
</body>
</html>
