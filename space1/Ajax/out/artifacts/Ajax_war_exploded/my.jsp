<%--
  Created by IntelliJ IDEA.
  User: guyao
  Date: 2018/12/11
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my first ajax page</title>
    <script type="text/javascript">
        function getData() {
            //获取元素对象
            var showdiv = document.getElementById("showdiv");
            //修改元素内容
            showdiv.innerHTML = "哈哈这两天的天气真的是相当的可以的，真的是棒棒的";
        }
    </script>
    <style type="text/css">
        #showdiv{
            border: solid 1px;
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
<h3>欢迎登陆王者峡谷</h3>
<hr>
<input type="button" value="test" onclick="getData()" />
<div id="showdiv"></div>
</body>
</html>
