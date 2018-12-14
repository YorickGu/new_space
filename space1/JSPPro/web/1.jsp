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

    jsp文件在转义成其对应的servlet文件的时候自动生成的并声明的对象。我们在jsp页面中直接使用即可。
    注意：内置对象在jsp页面中使用，使用局部代码块或者脚本端语句来使用，不能够在全局代码块中使用。
    内容：
        1. pagecontext
        页面上下文对象，这里面封存了另外8个对象
        注意：每个jsp文件都拥有一个pagecontext对象。
        作用域范围：当前页面

        2. request：封存当前请求数据的对象，由tomcat服务器创建。
        3. responce：用来响应请求处理结果，可以设置响应头，也可以重定向。
        4. session：此对象用来存储用户的不同请求的共享数据
        5. application：也就是servletcontext对象，一个项目只有一个，存储用户共享数据的对象，以及完成其他操作。
        6. out ：是jsp内部使用，带有缓冲区的响应对象，效率高于responce
        7. page:代表当前jsp页面的对象，相当于Java中的this
        8. exception ：异常对象，存储了当前的异常信息。使用此对象需要在page指令中使用属性isErrorPage = true来开启
        9. config ：也就是servletconfig，主要用来获取web.xml中的配置数据，完成一些初始化数据的读取。

        四个作用域对象：
        pagecontext：当前页面  解决了在当前页面内的数据共享问题，获取其他内置对象。
        request：一次请求 一次请求的servlet的数据共享问题  通过请求转发，将数据流转给下一个serlet
        session：一次会话 一个用户的不同请求的数据共享问题 将数据从一次请求流转给其他请求
        application：项目内 不同用户的数据共享问题 将数据从一个用户流转给其他用户

        作用：数据流转，都是数据共享的不同方式


        在jsp中，资源路径可以使用相对路径完成跳转，但是，
        问题一：资源位置不可随意更改。
        问题二：需要使用../进行文件夹的跳出，使用比较麻烦

        使用绝对路径：


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
