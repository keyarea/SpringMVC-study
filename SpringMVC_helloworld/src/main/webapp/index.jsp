<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2019-10-09
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloworld</title>
</head>
<body>

<a href="hello">helloworld</a>

<hr>

<h1>测试RequestMapping</h1>
<a href="haha/handle01">写在方法上的RequestMapping</a>

<hr>
<h1>测试RequestMapping的属性</h1>
<a href="haha/handle02">handle02</a>
<form action="haha/handle02" method="post">
    <input type="submit" value="测试post请求">
</form>

<hr>
<p>测试params属性</p>
<a href="haha/handle03">handle03-测试params</a>

<hr>
<p>测试headers属性</p>
<a href="haha/handle04">handle04-测试headers</a>

<hr>

<h3>RequestMapping- Ant风格的url</h3>
<a href="antTest01">antTest01- 精确的地址</a>

<hr>
<h3>测试PathVariable</h3>
<a href="user/hello">TestPathVariable</a>
</body>
</html>
