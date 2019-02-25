<%--
  Created by IntelliJ IDEA.
  User: gyj
  Date: 2018/12/27
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>页面展示</title>
</head>
<body>
<table align="center" border="1">
    <tr>
        <th>编号</th>
        <th>名字</th>
        <th>价格</th>
        <th>产地</th>
    </tr>
    <c:forEach items="${list}" var="peo">
        <tr>
            <td>${peo.id}</td>
            <td>${peo.name}</td>
            <td>${peo.price}</td>
            <td>${peo.production}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
