<%--
  Created by IntelliJ IDEA.
  User: key
  Date: 2019/10/23
  Time: 10:07
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

<a href="${ctp}/hello">hello</a>
<a href="${ctp}/handle01?i=10">handle01</a>
<a href="${ctp}/handle02?username=admin">handle02</a>
<a href="${ctp}/handle03">handle03</a>
<a href="${ctp}/handle04">handle04</a>
</body>
</html>
