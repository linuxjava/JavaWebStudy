<%--
  Created by IntelliJ IDEA.
  User: robincxiao
  Date: 2020/1/19
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h1>
        <%= request.getSession().getAttribute("username")%>
    </h1>
</body>
</html>
