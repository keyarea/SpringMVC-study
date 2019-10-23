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
<!-- 文件上传
    1、文件上传表单准备  ：enctype=“multipart/form-data”
    2、导入fileupload：
        // https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload
        compile group: 'commons-fileupload', name: 'commons-fileupload', version: '1.3.3'
        // https://mvnrepository.com/artifact/commons-io/commons-io
        compile group: 'commons-io', name: 'commons-io', version: '2.6'
    3、javaWeb：
        ===
    4、SpringMVC：只要在SpringMVC配置文件中，编写一个配置，配置文件上传解析器（multipartResolver）；
    5、文件上传处理
        在处理器方法上写一个
            @RequestParam("headerimg") MultipartFile file, 封装当前文件的信息
 -->
${msg}
<form action="${ctp}/upload" enctype="multipart/form-data" method="post">
    用户头像：<input name="headerimg" type="file"> <br>
    用户头像：<input name="headerimg" type="file"> <br>
    用户头像：<input name="headerimg" type="file"> <br>
    用户头像：<input name="headerimg" type="file"> <br>
    用户名：<input name="username" type="text"> <br>
    <input type="submit">
</form>

</body>
</html>
