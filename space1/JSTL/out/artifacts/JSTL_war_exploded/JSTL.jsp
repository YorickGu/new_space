<%--
  Created by IntelliJ IDEA.
  User: guyao
  Date: 2018/12/14
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    使用JSTL学习：
    作用：提高在jsp中的逻辑代码的编写效率，使用标签。
    使用：JSTL的核心标签库，
          JSTL的格式化标签库
          JSTL的SQL标签库
          JSTL的函数标签库
          JSTL的XML标签库

      jstl的核心标签库
      1、导入jar包
      2、需要声明jstl标签库的引入（核心标签库）
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      3、<c:out value="${str}" default="厉害了你内"></c:out>
      内容：数据可以为常量值也可以为EL表达式，
      作用：将数据输出给客户端
        <c:set var="hello" value="come on baby" scope="application"></c:set>
        作用：存储数据到作用域对象中
        var：表示存储的键名
        value：表示存储的数据
        scope：表示存储的作用域对象page、request、session、application
        <c:remove var="hello" scope="application" />
        作用：删除作用域中指定键的数据
        var：表示要删除的键的名字：
        scope：要删除的指定的作用域
        注意：如果在删除的时候没有指定具体的作用域，默认是将符合键的名字的数据全部删除。

        逻辑标签：<c:if test="${EL表达式}}">
                    前端代码
                    </c:if>
             只不过就是逻辑判断标签需要依赖于EL的逻辑运算，也就是表达式中涉及到的数据必须要从作用域中获取。
             循环标签：
             <c:forEach begin="1" end="6" step="2" varStatus="vs">
                     <i>嘿嘿嘿</i><br />
            </c:forEach>

             begin：声明循环开始的位置
             end：声明循环结束的位置
             step:声明自增的步长
            varStatus:声明变量记录的每次循环的数据（角标、次数，是否是第一次循环，是否是最后一次循环）
            注意：数据存储在作用域中，需要使用EL表达式来获取数据。
            例如：${vs.index}--${vs.count}--${vs.first}--${vs.last}

--%>
<%
    request.setAttribute("str","可以的，这个功能我很喜欢,真是优秀！");
%>
<%--基本标签学习--%>
<h3>
    基本标签学习
</h3>
<c:out value="哈哈"></c:out> ---哈哈
<c:out value="${str}" default="厉害了你内"></c:out>
<c:set var="hello" value="come on" scope="page"></c:set>
<c:set var="hello" value="come on baby" scope="application"></c:set>
<%--指定作用域--%>
<br />
<c:out value="hello"></c:out>
<c:out value="${applicationScope.hello}"></c:out>
<c:remove var="hello" scope="application" />
<hr />
<h3>
    逻辑标签学习
</h3>
<c:set var="a" value="4"></c:set>
<c:if test="${a>3}">
    <b>嘿嘿，用JSTL标签来这样写的话，是有点爽歪歪</b>
    <b>只不过JSTL是依赖于EL表达式来进行的，所以必须要在作用域中进行赋值</b>
</c:if>
<br />
<c:set var="score" value="85" />
<c:choose>
    <c:when test="${score<60}">
        <i>那就这样吧</i>
    </c:when>
    <c:when test="${score>60&&score<70}">
        <i>六十几分还凑活吧</i>
    </c:when>
    <c:when test="${score>70&&score<80}">
        <i>七十几分也敢出来秀优越</i>
    </c:when>
    <c:when test="${score>80&&score<90}">
        <i>八十几分在我这里也就刚刚及格</i>
    </c:when>
    <c:otherwise>
        <i>这样就很棒帮了，哈哈</i>
    </c:otherwise>
</c:choose>

<br />
<table>
    <tr>
        <td>课程名称</td>
        <td>教师</td>
        <td>价格</td>
        <td>重要性</td>
    </tr>
    <tr>
        <td>Java</td>
        <td>顾垚江</td>
        <td>不要钱</td>
        <td>很重要</td>
    </tr>
    <tr>
        <td>python</td>
        <td>张老师</td>
        <td>不要钱</td>
        <td>很重要</td>
    </tr>
</table>
<br />
<hr />

<c:forEach begin="1" end="6" step="2" varStatus="vs">
    ${vs.index}--${vs.count}--${vs.first}--${vs.last}<i>嘿嘿嘿</i><br />
</c:forEach>