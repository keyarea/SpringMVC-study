<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2019-10-18
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工添加</title>
</head>
<body>
<h1>员工添加</h1>
<%--表单标签--%>
<%--通过SpringMVC的表单标签可以实现将模型数据中属性和HTML表单元素相绑定,以实现表单数据更便捷编辑和表单值的回显--%>
<%--modelAttribute="":
    以前我们的表单标签会从请求域中获取一个command对象的值,把这个command对象的每一个属性对应的显示出来
    可以告诉SpringMVC不要去取command的值,我放了一个modelAttribute指定的值;
    取对象的key就用modelAttribute指定的值;
--%>

<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>

<form:form action="${ctp}/emp" modelAttribute="employee" method="post">
    <%--  path就是原来html-input中的name项
          path:
            当作原生的name项;
            自动回显隐含模型中某个对象对应的这个属性的值;

          SpringMVC认为,表单数据中的每一项最终都是要回显的;
            path:指定一个属性;这个属性是从隐含模型(请求域中取出的某个对象中的属性);
            path指定的每一个属性,请求域中必须有一个对象,拥有这个属性;
                这个对象就是请求域中的command;
      --%>

    lastName:<form:input path="lastName"/>
    <br>
        <form:errors path="lastName"/>--> ${errorInfo.lastName}
    <br>
    email:<form:input path="email"/>
    <br>
        <form:errors path="email"/>--> ${errorInfo.email}
    <br>
    gender: <br>
        男:<form:radiobutton path="gender" value="1"/> <br>
        女:<form:radiobutton path="gender" value="0"/> <br>
    <br>
    部门:
        <%--  items="" :指定要遍历的集合;自动遍历;遍历出的每一个元素是一个department对象
              itemLabel="属性" : 指定遍历出的这个对象哪个属性是作为option标签体的值
              itemValue="属性" : 指定刚才遍历出的这个对象哪个属性是作为要提交的value值
         --%>
    <form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id" >
    </form:select>

    <input type="submit" value="添加员工">
</form:form>


<%--<form action="" method="post">--%>
<%--    lastname: <input name="lastname" type="text"><br>--%>
<%--    email: <input name="email" type="email"><br>--%>
<%--    gender:--%>
<%--        <br>男:<input type="radio" name="gender" value="1">--%>
<%--        <br>女:<input type="radio" name="gender" value="0"><br>--%>
<%--    部门: <select name="department.id">--%>
<%--            <c:forEach items="${departments}" var="department">--%>
<%--                <option value="${department.id}" >${department.departmentName}</option>--%>
<%--            </c:forEach>--%>
<%--         </select>--%>

<%--    <input type="submit" value="添加员工">--%>
<%--</form>--%>



</body>
</html>
