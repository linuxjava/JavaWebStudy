<%--
  Created by IntelliJ IDEA.
  User: robincxiao
  Date: 2020/2/2
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>

    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <style type="text/css">
        .container {
            width: 400px;
            margin-top: 150px;
        }

        #login_title {
            text-align: center;
            margin-bottom: 50px;
        }

        .input-group {
            width: 100%;
            margin-bottom: 15px;
        }

        #checkcode-input {
            width: 260px;
            margin-right: 0px;
        }

        #checkcode-img {
            float: right;
        }

        #login_register {
            margin-top: 40px;
        }

        #btn_login, #btn_register {
            width: 48%;
        }

        #btn_register {
            float: right;
        }

        #alert_error{
            padding-top: 7px;
            padding-bottom: 7px;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 id="login_title">管理员登录</h3>

    <form role="form" action="${pageContext.request.contextPath}/loginServlet" method="post">
        <label for="username">用户名 :</label>
        <div class="input-group">
            <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名">
        </div>

        <label for="password">密码 :</label>
        <div class="input-group">
            <input type="text" name="password" class="form-control" id="password" placeholder="请输入密码">
        </div>

        <label for="checkcode-input">验证码 :</label>
        <div class="form-inline">
            <input type="text" name="checkcode" id="checkcode-input" class="form-control" placeholder="请输入验证码">
            <img src="${pageContext.request.contextPath}/checkcode" title="看不清点击刷新" id="checkcode-img"/>
        </div>

        <div id="login_register" class="form-inline">
            <button type="submit" id="btn_login" class="btn btn-primary">登录</button>
            <button type="button" id="btn_register" class="btn btn-primary">注册</button>
        </div>
    </form>

    <c:if test="${not empty requestScope.get('errMsg')}">
        <div id="alert_error" class="alert alert-warning">
            ${requestScope.get('errMsg')}
        </div>
    </c:if>

</div>
</body>

<script type="text/javascript">
    $("#checkcode-img").click(function () {
        this.src = "${pageContext.request.contextPath}/checkcode?time=" + new Date().getTime();
    });

    /**
     * 显示错误提示
     */
    function showError() {
        $('.alert-warning').removeClass('hide').addClass('in')
    }

    /**
     * 隐藏错误提示
     */
    function hideError() {
        $('.alert-warning').removeClass('in').addClass('hide')
    }


</script>

</html>
