<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2019-10-14
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<a href="handle01">handle01</a>

<hr>
<%--SpringMVC如何给页面携带数据过来:--%>

<p>SpringMVC怎么携带数据给页面</p>
<a href="handle02">handle02</a>
<br>
<a href="handle03">handle03</a>
<br>
<a href="handle04">handle04</a>
<br>
<a href="handle05">handle05</a>
<hr>
<form action="updateBook" method="post">
    <input type="hidden" value="7" name="id"> <br>
    图书： 西游记 <br>
    作者： <input type="text" name="author" ><br>
    价格：<input type="text" name="price" ><br>
    库存：<input type="text" name="stock" ><br>
    销量：<input type="text" name="sales" ><br>
    <input type="submit" value="修改图书">
</form>
</body>
</html>
