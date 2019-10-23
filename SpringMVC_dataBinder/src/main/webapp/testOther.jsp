<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/10/23
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   pageContext.setAttribute("ctp", request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${ctp}/testRequestBody" method="post">
    <input name="username" value="tomcat">
    <input name="password" value="123456">
    <input type="submit">
</form>

</body>
</html>
