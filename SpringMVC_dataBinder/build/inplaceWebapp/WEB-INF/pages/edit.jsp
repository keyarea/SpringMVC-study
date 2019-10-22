<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2019-10-18
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<html>
<head>
    <title>修改员工</title>
</head>
<body>
<h1>员工修改</h1>

<form:form modelAttribute="employee" action="${ctp}/emp/${employee.id}" method="post">
    <input name="_method" value="put" type="hidden">
    <input name="id" value="${employee.id}" type="hidden">
   email: <form:input path="email" /> <br>
    gender: <br>
    男: <form:radiobutton path="gender" value="1"/><br>
    女: <form:radiobutton path="gender" value="0"/> <br>
    部门: <form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"/> <br>
    <input type="submit" value="修改">
</form:form>

</body>
</html>
