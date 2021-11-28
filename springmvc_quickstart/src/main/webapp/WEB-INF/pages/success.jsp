<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/10/18
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--el表达式获取request域中存储的数据--%>
<h1>Success...${username}</h1>

<%
    System.out.println("视图跳转渲染完成，整个流程执行完毕了！");
%>
</body>
</html>
