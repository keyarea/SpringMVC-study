<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/10/10
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rest</title>
</head>
<body>

<%--
  在页面上只能发起get post请求，其他的请求无法使用；

  Spring提供了对REST风格支持：
	1. SpringMVC中有一个Fliter，它可以把普通的请求转化为规定形式的请求；
    2. 如何发其他形式的请求？
       按照以下的要求： 1. 创建一个post类型的表单 2. 表单中携带一个_method的参数 3. 这个_method的值就是DELTE、PUT
--%>
<a href="book/1">得到1号图书</a>

<hr>
<form action="book/1" method="post">
    <input type="submit" value="添加一号图书" />
</form>

<hr>
<form action="book/1" method="post">
    <input name="_method" value="delete" />
    <input type="submit" value="删除一号图书" />
</form>
<hr>

<form action="book/1" method="post">
    <input name="_method" value="put" />
    <input type="submit" value="修改一号图书" />
</form>

</body>
</html>
