<%--
  Created by IntelliJ IDEA.
  User: guyao
  Date: 2018/12/19
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    a{
        color: black;
        text-decoration: none;
    }
    a:hover{
        color: red;
    }
</style>
<html>
<head>
    <title>hello</title>
</head>
<body>
<table border="1">
    <tr>
        <th>花卉编号</th>
        <th>花卉名称</th>
        <th>价格（元）</th>
        <th>原产地</th>
    </tr>
    <c:forEach items="${list}" var="flower">
        <tr>
            <td>${flower.id}</td>
            <td>${flower.name}</td>
            <td>${flower.price}</td>
            <td>${flower.production}</td>
        </tr>
    </c:forEach>
</table>
<a href="#">添加花卉信息</a>
</body>
</html>
