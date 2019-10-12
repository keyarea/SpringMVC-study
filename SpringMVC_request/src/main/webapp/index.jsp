<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/10/11
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="hello">hello</a>
<hr>
<p>查看url中携带的参数信息</p>
<a href="handle02?username=tomcat">handle02</a>
<hr>
<p>查看Headers信息中的User-Agent</p>
<a href="handle03">handle03</a>
<hr>
<p>查看cookie的值</p>
<a href="handle04">handle04</a>
<hr>

<form action="book" method="post">
    书名：<input type="text" name="bookName"> <br>
    作者：<input type="text" name="author"> <br>
    价格：<input type="text" name="price"> <br>
    库存： <input type="text" name="stock"><br>
    销量: <input type="text" name="sales"><br>
    <hr>
    省：<input type="text" name="address.province">
    市：<input type="text" name="address.city">
    街道： <input type="text" name="address.street">
    <input type="submit" value="添加">
</form>
</body>
</html>
