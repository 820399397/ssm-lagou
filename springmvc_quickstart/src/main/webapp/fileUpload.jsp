<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/10/22
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试文件上传</title>
</head>
<body>
<%--
    1.请求方式为post
    2.表单为多部件上传表单enctype="multipart/form-data"
    3.必须存在type="file" 的表单项
--%>
<form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">
    名称: <input type="text" name="username"> <br>
    上传文件： <input type="file" name="filePic"> <br>
    <input type="submit" value="单文件上传">
</form>
<br>
<%--多文件上传--%>
<form action="${pageContext.request.contextPath}/filesUpload" method="post" enctype="multipart/form-data">
    名称: <input type="text" name="username"> <br>
    上传文件： <input type="file" name="filePic"> <br>
    <input type="file" name="filePic"> <br>
    <input type="submit" value="多文件上传">
</form>
</body>
</html>
