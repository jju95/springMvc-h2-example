<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="./js/index.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시판 목록</title>
    <style>
        table {
            width: 100%;
            border: 1px solid #444444;
            border-collapse: collapse;
        }
        table th {
            border: 1px solid #444444;
            text-align: center;
            height: 40px;
            background-color: dodgerblue;
            color: cornsilk;
        }
        table td {
            border: 1px solid #444444;
            text-align: center;
        }
    </style>


</head>
<body>
<div style="text-align: center;">
    <h1>입력 폼</h1>
    <form:form method="post" modelAttribute="board" action="/board/create" enctype="multipart/form-data">
    <table style="width: 700px; margin: auto">
    <thead>
        <th></th>
        <th>작성란</th>
    </thead>
    <tbody>
        <tr>
            <td>
                <form:label path="title" >글 제목</form:label>
            </td>
            <td>
                <form:input path="title" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="writer">닉네임</form:label>
            </td>
            <td>
                <form:input path="writer" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="content">글 내용</form:label>
            </td>
            <td>
                <form:textarea path="content" />
            </td>
        </tr>
        <tr>
            <td>
                <span>썸네일</span>
            </td>
            <td>
                <input type="file" name="image" accept="image/png, image/jpeg"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="작성">
            </td>
        </tr>
    </tbody>
    </table>
    </form:form>
    <div>
        <a href="/board/list">글 목록으로 돌아가기</a>
    </div>
</div>
</body>
</html>