<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<div class="container">
    <div>
        <h3>키워드 등록</h3>
    </div>

    <div>
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label class="form-label">키워드 명:</label>
                <input type="text" name="name" class="form-control form-control-sm">
            </div>

            <div class="form-group mt-3">
                <button class="btn btn-sm btn-primary">등록</button>
                <a href="/domain/list">
                    <button type="button"
                            class="btn btn-sm btn-secondary">취소
                    </button>
                </a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
