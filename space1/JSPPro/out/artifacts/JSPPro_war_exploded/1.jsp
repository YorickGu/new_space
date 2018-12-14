<%--
  Created by IntelliJ IDEA.
  User: guyao
  Date: 2018/12/5
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*" language="java" %>
<%@ page errorPage="error.jsp" %>
<%--
    JSP的三种注释
        会被转译，也会被发送，但是不会被浏览器执行
    Java语言注释
        会被转译，但是不会被servlet执行
    JSP注释
        不会被转译
    JSP的page指令学习
    <%@page 属性名="属性值" 属性名="属性值"%>
    language：声明jsp要被转译的语言。
    import：导入的java的包,不同的包用逗号隔开
    errorpage;：设置jsp运行错误跳转的页面
    extends：设置jsp转译的Java文件要继承的父类（包名+类名）
    作用：配置jsp文件的转译相关参数

    jsp的代码域
    <%

    %>
    JSP的局部代码块中声明的Java代码会被原样转译到jsp对应的servlet文件的_Jspservice方法中，
    代码块中声明的变量都是局部变量
    使用：<%Java代码%>

    缺点：
    使用局部代码块再jsp中书写麻烦，阅读困难
    开发：servlet进行逻辑处理，使用jsp进行页面展现。

    JSP的全局代码块：
        主要是帮我们进行声明方法和变量，

    注意：全局代码块声明的代码，在局部代码块中调用
    jsp的脚本段语句：
        特点：帮助我们快速地获取变量或者方法的返回值作为数据响应给浏览器。
        使用：<%=变量名或者方法名%>
        注意：在变量名或者是方法名后面不要加分号
        位置：除jsp语法以外的任意位置

    JSP的静态引入和动态引入
    静态引入：<%@include file="要引入的jsp文件的相对路径"%>
    特点：会将引入的jsp文件和当前的jsp文件转译成一个java文件使用
    在网页中也就显示出了合并后的显示效果
    注意：静态引入的jsp文件不会单独转译成java（servlet）文件。
    当前文件和静态引入的jsp文件中不能够使用java代码中声明的同名变量。

    动态引入：动作标签
    <jsp:include page = "要引入的jsp文件的相对路径"></jsp:include>
    特点：
    会将引入的jsp文件单独转译，在当前文件转译好的java文件中。调用引入的jsp文件的转译文件。
    在网页中显示合并后的显示效果。
    动态引入允许声明同名变量。

    降低jsp代码的冗余度，便于维护

    jsp的请求转发forward
    <jsp:forward page="相对路径"></jsp:forward>

    特点：一次请求；
    地址栏信息不变
    注意：在转发标签的两个标签中间除了写数据<jsp:param name="str" value="OK"/>子标签不会报错，其他的任意字符都会报错。
    name属性为附带的数据的键名
    value属性为附带的数据内容
    注意：会将数据以？的形式拼接在转发路径的后面


    jsp的九大内置对象：




--%>
<html>
<head>
    <title>My First JSP File</title>
    <meta charset="utf-8"/>
</head>
<body>
<h1>好的</h1>
<hr/>
<h3>
    jsp的基本学习
</h3>
<hr/>
<b>哈哈，jsp这是太好用啦可以的，好的哇</b><br/>
<%
    out.println("哈哈哈");
    test();
    String str = "Hello!!Yorick";
%>
<br/>
<a>顾垚江</a>
<br/>
<%
    out.println(str);
%><br/>
<%=str%>
<!--全局代码块-->
<%!
    public void test(){
        System.out.println("我是全局代码块");
    }

%>

<!--jsp的转发forward标签-->
<jsp:forward page="forward.jsp">
    <jsp:param name="str" value="OK"/>
</jsp:forward>


<!--jsp的九大内置对象学习-->
<%
    request.getAttribute("str");
%>
</body>
</html>
