<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/10/19
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mvc可以接收的请求参数类型的测试</title>
</head>
<body>
<%--tomcat8.5+：已经解决了get请求方式中携带参数的值是中文出现的乱码问题--%>
<a href="${pageContext.request.contextPath}/user/simpleParams?id=1&username=马双">传递基本数据类型的参数</a>
<br>
<form action="${pageContext.request.contextPath}/user/pojoParams" method="post">
    <%--需要注意的是：name的值要和实体类中的属性名一致，因为要经过setXxx()方法进行封装
            将表单中的参数赋值给实体类中的属性上
        --%>
    学号：<input type="text" name="id"><br>
    姓名：<input type="text" name="name"><br>
        <%--post请求方式下，传递中文数据到达后台会出现乱码，因为编码和解码的方式不同，
        配置过滤器使得编码和解码方式一致--%>
    <input type="submit" value="对象类型参数">
</form>
<br>
<form action="${pageContext.request.contextPath}/user/arrayParams" method="post">
    <%--说明：
            1.复选框value属性的值是传送到后台控制器的数据
            2.复选框中文本内容的值是标签后面的内容，标签后面的内容是什么，页面中显示什么内容
    --%>
    编号：<input type="checkbox" name="ids" value="1">1
            <input type="checkbox" name="ids" value="2">2
            <input type="checkbox" name="ids" value="3">3
            <input type="checkbox" name="ids" value="4">4
    <input type="submit" value="传递数组类型参数">
</form>
<br>
<form action="${pageContext.request.contextPath}/user/listParams" method="post">
    关键字：<input type="text" name="keyWords"><br>
    user对象: <br>
            <input type="text" name="user.id" placeholder="学号"><br>
            <input type="text" name="user.name" placeholder="姓名"><br>
    list对象： <br>
    第一个元素
            <input type="text" name="userList[0].id" placeholder="学号">
            <input type="text" name="userList[0].name" placeholder="姓名"> <br>
    第二个元素
            <input type="text" name="userList[1].id" placeholder="学号">
            <input type="text" name="userList[1].name" placeholder="姓名"> <br>
    map对象: <br>
    第一个元素
            <input type="text" name="userMap['u1'].id" placeholder="学号">
            <input type="text" name="userMap['u1'].name" placeholder="姓名"> <br>
    第二个元素
            <input type="text" name="userMap['u2'].id" placeholder="学号">
            <input type="text" name="userMap['u2'].name" placeholder="姓名"> <br>

    <input type="submit" value="传递复杂类型的参数">
</form>
<br>
<%--传递日期参数，传递的日期参数格式必须是2020/12/12这样式的，否则框架不会转换的--%>
<form action="${pageContext.request.contextPath}/user/converterParam">
    日期： <input type="text" name="birthday"> <br>
    <input type="submit" value="传递日期类型的参数">
</form>
<br>
<%--演示@RequestParam注解--%>
<a href="${pageContext.request.contextPath}/user/findByPage?pageNo=2">
    分页查询
</a>

<%--测试加载静态资源--%>
<script src="${pageContext.request.contextPath}/js/jQuery.min.js"></script>
</body>
</html>
