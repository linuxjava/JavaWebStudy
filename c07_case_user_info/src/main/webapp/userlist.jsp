<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robincxiao
  Date: 2020/2/2
  Time: 21:31
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

    <title>用户列表</title>

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
            width: 1600px;
            margin-top: 50px;
        }

        #title {
            text-align: center;
            margin-bottom: 50px;
        }

        .form-group {
            margin-right: 10px;
        }

        #btn_add_user {
            margin-right: 10px;
        }

        th, td {
            text-align: center;
        }

        thead {
            background-color: #DFF0D8;
        }
    </style>
</head>

<body>

<div class="container">
    <h3 id="title">用户信息列表</h3>

    <div style="float: left">
        <form class="form-inline" role="form" method="post" action="${pageContext.request.contextPath}/pageServlet?queryType=all&pageIndex=${pi.pageIndex}">
            <div class="form-group">
                <label for="username">姓名: </label>
                <input type="text" name="username" class="form-control" id="username" placeholder="请输入姓名"
                       value="${pi.condition.username}"/>
            </div>

            <div class="form-group">
                <label for="address">籍贯: </label>
                <input type="text" name="address" class="form-control" id="address" placeholder="请输入籍贯"
                       value="${pi.condition.address}"/>
            </div>

            <div class="form-group">
                <label for="email">邮箱: </label>
                <input type="text" name="email" class="form-control" id="email" placeholder="请输入邮箱"
                       value="${pi.condition.email}"/>
            </div>

            <button type="submit" class="btn btn-default">查询</button>
            <button type="reset" class="btn btn-default">重置</button>
        </form>
    </div>

    <div style="float: right;">
        <a id="btn_add_user" href="${pageContext.request.contextPath}/adduser.jsp" class="btn btn-primary">添加联系人</a>
        <a id="delSelected" href="javascript:void(0);" class="btn btn-primary">删除选中</a>
    </div>

    <form id="user_list_form" role="form" method="post" action="${pageContext.request.contextPath}/delAccountServlet?pageIndex=${pi.pageIndex}">
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.pi.accounts}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.username}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?uid=${user.id}
                            &pageIndex=${pi.pageIndex}&username=${pi.condition.username}&address=${pi.condition.address}&email=${pi.condition.email}">修改</a>&nbsp;
                        <input type="button" class="btn btn-default btn-sm" onclick="delOne(${user.id}, ${pi.pageIndex})" value="删除"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

    <ul class="pagination" style="float: right">
        <c:if test="${1 == requestScope.pi.pageIndex}">
            <li class="disabled"><a href="#">&laquo;</a></li>
        </c:if>
        <c:if test="${1 != requestScope.pi.pageIndex}">
            <li><a href="${pageContext.request.contextPath}/pageServlet?pageIndex=${requestScope.pi.pageIndex - 1}&username=${pi.condition.username}&address=${pi.condition.address}&email=${pi.condition.email}">&laquo;</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${requestScope.pi.totalPage}" step="1" var="index">
            <c:if test="${index == requestScope.pi.pageIndex}">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/pageServlet?pageIndex=${index}&username=${pi.condition.username}&address=${pi.condition.address}&email=${pi.condition.email}">
                            ${index}
                    </a>
                </li>
            </c:if>

            <c:if test="${index != requestScope.pi.pageIndex}">
                <li>
                    <a href="${pageContext.request.contextPath}/pageServlet?pageIndex=${index}&username=${pi.condition.username}&address=${pi.condition.address}&email=${pi.condition.email}">
                            ${index}
                    </a>
                </li>
            </c:if>
        </c:forEach>

        <c:if test="${requestScope.pi.totalPage == requestScope.pi.pageIndex}">
            <li class="disabled"><a href="#">&raquo;</a></li>
        </c:if>
        <c:if test="${requestScope.pi.totalPage != requestScope.pi.pageIndex}">
            <li><a href="${pageContext.request.contextPath}/pageServlet?pageIndex=${requestScope.pi.pageIndex + 1}&username=${pi.condition.username}&address=${pi.condition.address}&email=${pi.condition.email}">&raquo;</a>
            </li>
        </c:if>

        <span style="font-size: 25px;margin-left: 10px;">共${pi.size}条记录，共${pi.totalPage}页</span>
    </ul>


</div>
</body>

<script type="text/javascript">
    /**
     * 全选和反选
     */
    $("#firstCb").click(function () {
        var cbs = document.getElementsByName("uid");
        for (var i = 0; i < cbs.length; i++) {
            cbs[i].checked = this.checked;
        }
    });

    /**
     * 删除所有选中
     */
    $("#delSelected").click(function () {
        var cbs = document.getElementsByName("uid");
        var flag = false;
        for (var i = 0; i < cbs.length; i++) {
            if (cbs[i].checked) {
                flag = true;
            }
        }

        if (flag) {
            $("#user_list_form").submit();
        }
    });

    /**
     * 删除一个
     * @param uid
     */
    function delOne(uid, pageIndex) {
        location.href = "${pageContext.request.contextPath}/delAccountServlet?uid=" + uid + "&pageIndex=" + pageIndex;
    }

</script>

</html>
