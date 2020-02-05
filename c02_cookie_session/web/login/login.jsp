<%--
  Created by IntelliJ IDEA.
  User: robincxiao
  Date: 2020/1/19
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录案例</title>
</head>
<body>
<form action="/c02/loginservlet" method="post">
    用户名: <input type="text" name="username" placeholder="请输入用户名"/><br/>
    密码: <input type="text" name="pwd" placeholder="请输入用户名"/><br/>
    验证码: <input type="text" name="code" placeholder="请输入验证码"/> <img id="checkcode" src="/c02/checkcode"><br/>
    <input type="submit" value="登录">
</form>
<div>
    <c:if test="${not empty requestScope.get('error_msg')}">
        ${requestScope.get("error_msg")}
    </c:if>
</div>
</body>
<script type="text/javascript">
    document.getElementById("checkcode").onclick = function () {
        this.src = "/c02/checkcode?time=" + new Date().getTime();
    };
</script>
</html>
