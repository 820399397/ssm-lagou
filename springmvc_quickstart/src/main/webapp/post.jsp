<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/10/22
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restful风格下post请求方式</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/restful/user" method="post">
    编号： <input type="text" name="id"> <br>
    姓名： <input type="text" name="name"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
