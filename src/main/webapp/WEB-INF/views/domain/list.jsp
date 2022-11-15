<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DomainList</title>
    <script src="/resources/jquery/jquery-3.6.1.min.js"></script>
    <script src="/resources/bootstrap/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
</head>
<body>
<h5 class="text-center">DomainList(항목 사전)</h5>


<form>

    <div class="row mb-2">
        <div class="d-flex justify-content-center">
            <div class="col-1">
                <select name="search" class="form-control form-control-sm">
                    <option value="0">선택</option>
                    <option value="1" ${pager.search == 1 ? 'selected' : ''}>항목 번호</option>
                    <option value="2" ${pager.search == 2 ? 'selected' : ''}>항목명</option>
                </select>
            </div>
            <div class="col-5">
                <input type="text" name="keyword" class="form-control form-control-sm"
                       value="${pager.search == 0 ? '' : pager.keyword}">
            </div>
            <div class="col-1 d-grid">
                <button class="btn btn-primary btn-sm">검색</button>
            </div>
        </div>
    </div>
</form>
<div class="justify-content-center d-flex" style="margin-top: 20px">
    <div style="width: auto; height: auto">
        <table border="1" class="table table-striped-columns text-center">
            <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>항목명</th>
                <th>관리</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${list.size() < 1}">
                <tr>
                    <td colspan="5">검색 된 게임이 없습니다</td>
                </tr>
            </c:if>

            <c:forEach items="${list}" var="list">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.name}</td>
                    <td>
                        <a href="/keywords/${list.id}/list" style="text-decoration: none">용어 관리</a>
                        <a href="update/${list.id}" style="text-decoration: none">변경</a>
                        <a href="delete/${list.id}" style="text-decoration: none">삭제</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <ul class="pagination pagination-sm justify-content-center">
                <li class="page-item"><a href="?page=1" class="page-link">처음</a></li>
                <li class="page-item"><a href="?page=${pager.prev}" class="page-link">이전</a></li>
                <c:forEach var="page" items="${pager.list}">
                    <li class="page-item"><a href="?page=${page}"
                                             class="page-link ${page eq pager.page ? 'active' : ''}">${page}</a></li>
                </c:forEach>
                <li class="page-item"><a href="?page=${pager.next}" class="page-link">다음</a></li>
                <li class="page-item"><a href="?page=${pager.last}" class="page-link">마지막</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="d-flex justify-content-center">
    <div>
        <a href="/domain/add" class="btn btn-sm btn-danger" style="margin-right: 5px"> 추가 </a>
    </div>
    <div>
        <a href="/" class="btn btn-sm btn-secondary"> 뒤로 </a>
    </div>
</div>
</body>
</html>
