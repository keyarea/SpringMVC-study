<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2019-10-18
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<html>
<head>
    <title>员工列表页面</title>
</head>
<body>
<h1>员工列表</h1>
<table style="" border="1"  cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>department</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender == 0?"女":"男"}</td>
            <td>${emp.department.departmentName}</td>
            <td>
                <a href="${ctp}/emp/${emp.id}">edit</a>
            </td>
            <td>
<%--                <a href="${ctp}/emp/${emp.id}"></a>--%>
                <form action="${ctp}/emp/${emp.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="删除">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="${ctp}/toaddpage">添加员工</a>
<form action="${ctp}/quickadd">
   <!-- 将员工的所有的信息都写上，自动封装对象 -->
    <input name="empinfo" value="empAdmin-admin@qq.com-1-101">
    <input type="submit" value="快速添加">
</form>
</body>
</html>
