<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/10/22
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax异步请求传输json数据格式的字符串</title>
</head>
<body>
<%--在网络传输中数据的格式有json、xml格式的。json比较流行--%>
<%--1.导入jQuery包，利用api发送ajax请求--%>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>

<%--2.按钮dom对象--%>
<button id="btn1">发送ajax异步请求,传递集合类型的json数据</button>
<button id="btn2">发送ajax异步请求,传递pojo类型的json数据</button>

<%--3.编写js代码，发送ajax异步请求--%>
<script type="text/javascript">
    // 3.1获取按钮对象，绑定单击事件
    $("#btn1").click(function () {
        let url = '${pageContext.request.contextPath}/user/ajaxRequestList';
        let data = '[{"id":1,"name":"张三"},{"id":2,"name":"李四"}]';
        $.ajax({
            type: 'POST',
            url: url,
            data: data,
            contentType: 'application/json;charset=utf-8',
            success: function (resp) {
                console.log(resp);
                alert(JSON.stringify(resp));
            }
        })
    });

    // 3.2获取按钮对象，绑定单击事件
    $("#btn2").click(function () {
        let url = '${pageContext.request.contextPath}/user/ajaxRequestPojo';
        let data = '{"id":1,"name":"徐国文"}';
        $.ajax({
            type: 'POST',
            url: url,
            data: data,
            contentType: 'application/json;charset=utf-8',
            success: function (resp) {
                console.log(resp);
                alert(JSON.stringify(resp));
            }
        })
    })

</script>
</body>
</html>
