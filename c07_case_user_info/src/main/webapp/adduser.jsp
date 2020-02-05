<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robincxiao
  Date: 2020/2/3
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>添加联系人</title>

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
            width: 1200px;
            margin-top: 50px;
        }

        #title {
            text-align: center;
            margin-bottom: 50px;
        }

        .input-group{
            width: 100%;
            margin-bottom: 15px;
        }

        .btn{
            width: 100px;
            margin-right: 10px;
        }

        .form-inline{
            margin-top: 30px;
        }

    </style>

</head>
<body>
<div class="container">
    <h3 id="title">添加联系人</h3>

    <form role="form" action="${pageContext.request.contextPath}/addAccountServlet">
        <label for="username">用户名 :</label>
        <div class="input-group">
            <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名">
        </div>

        <div class="form-group">
            <label for="username">性别 :</label>
            <input type="radio" name="gender" value="男" checked="checked" style="margin-left: 10px">男
            <input type="radio" name="gender" value="女" style="margin-left: 5px">女
        </div>

        <label for="username">年龄 :</label>
        <div class="input-group">
            <select name="age" class="form-control" id="age">
                <c:forEach begin="15" end="70" step="1" var="age">
                    <option value="${age}">${age}</option>
                </c:forEach>
            </select>
        </div>

        <label for="username">籍贯 :</label>
        <div class="input-group">
            <select name="address" class="form-control" id="address">
                <option value="陕西">陕西</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
            </select>
        </div>

        <label for="username">QQ :</label>
        <div class="input-group">
            <input type="text" name="qq" class="form-control" id="qq" placeholder="请输入QQ号">
        </div>

        <label for="username">Email :</label>
        <div class="input-group">
            <input type="text" name="email" class="form-control" id="email" placeholder="请输入邮箱">
        </div>

        <div class="form-inline" style="text-align: center">
            <button type="submit" id="btn_login" class="btn btn-primary">提交</button>
            <button type="reset" class="btn btn-primary">重置</button>
            <button type="button" class="btn btn-primary">返回</button>
        </div>
    </form>
</div>
</body>
</html>
