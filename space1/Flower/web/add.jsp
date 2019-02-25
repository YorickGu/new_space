<%--
  Created by IntelliJ IDEA.
  User: guyao
  Date: 2018/12/20
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        <%--页面加载完成后执行，相当于 window.omload=function(){}  $(document).ready(function(){})--%>
        $(function () {
            $("form").submit(function () {
                //表单选择器   ：input标签type属性值
                if ($(":text:eq(0)").val()==""||$(":text:eq(1)").val()==""||$(":text:eq(2)").val()==""){
                    alert("请填写完整信息");
                    //组织默认行为
                    return flase;
                }
            });
        })
    </script>
</head>
<body>
<form action="ins" method="post">
    <table border="1" align="center">
        <tr>
            <td aria-colspan="2" style="text-align: center;font-size: 30px;font-weight: bold;">
                花卉信息
            </td>
        </tr>
        <tr>
            <td><b>花卉名称</b></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><b>价格</b></td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td><b>原产地</b></td>
            <td><input type="text" name="production"></td>
        </tr>
        <tr>
            <td aria-colspan="2" align="center">
                <input type="submit" value="提交"/><input type="reset" value="重置">
        </tr>
    </table>
</form>
</body>
</html>
