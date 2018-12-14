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

        // Ajax的学习：
        //     1、Ajax的概念
        //         局部刷新技术，不是一门新技术，是多种技术的组合，是浏览器端的技术
        //     2、Ajax的作用
        //     可以实现在当前结果页中显示其他请求的响应内容
        //     3、Ajax的使用
        //     4、Ajax的基本流程
        //         创建Ajax的引擎对象
        //         覆写onreadystatement函数
        //             判断响应状态码
        //             获取响应内容  响应内容的格式
        //             处理响应内容（js操作文档结构）
        //         发送请求
        //
        //     5、Ajax的状态码
        //         Ajax的状态码
        //             readystate:0,1,2,3,4
        //             4:表示响应内容被成功接收
        //         响应状态码：
        //         200  表示一切正常
        //         404 资源未找到
        //         500 服务器繁忙
        //     6、Ajax的异步和同步
        //     使用Ajax.open(method,url,async)
        //     async 表示设置同步代码执行还是异步代码执行
        //     true表示异步执行 ，默认是异步执行 ，false表示同步
        //

        function getData() {
            //创建Ajax引擎对象
            var ajax;
            if (window.XMLHttpRequest) { //火狐的
                ajax = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                ajax = new window.ActiveXObject("Msxml12.XMLHTTP");
            }
            //覆写onreadystatement函数
            ajax.onreadystatechange = function () {
                //判断ajax的状态码
                if (ajax.readyState == 4) {
                    if (ajax.status == 200) {
                        //获取响应内容
                        var result = ajax.responseText;
                        //获取元素对象
                        var showdiv = document.getElementById("showdiv");
                        //修改元素内容
                        showdiv.innerHTML = result;
                    } else if (ajax.status == 404) {
                        var showdiv = document.getElementById("showdiv");
                        //修改元素内容
                        showdiv.innerHTML = "请求资源不在";
                    } else if (ajax.status == 500) {
                        var showdiv = document.getElementById("showdiv");
                        //修改元素内容
                        showdiv.innerHTML = "服务器繁忙";
                    }
                } else {
                    var showdiv = document.getElementById("showdiv");
                    showdiv.innerHTML = "<img src='img/2.gif' width='200px' height='100px'/>";
                }
            }
            //发送请求
            ajax.open("get", "ajax", false);
            ajax.send(null);
            alert("heihei");
        }
    </script>
    <style type="text/css">
        #showdiv {
            border: solid 1px;
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
<h3>欢迎登陆王者峡谷</h3>
<hr>
<input type="button" value="test" onclick="getData()"/>
<div id="showdiv"></div>
</body>
</html>
