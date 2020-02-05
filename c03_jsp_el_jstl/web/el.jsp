<%@ page import="cn.itcast.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: robincxiao
  Date: 2020/1/20
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <h2>运算符</h2>

    ${1 + 2} ${true && true} ${false || false}<br/>
    \${1 + 2}

    <h2>获取值</h2>
    <%
        request.setAttribute("name", "张三");
        session.setAttribute("name", "张三");

        User user = new User("张三", 20);
        session.setAttribute("user", user);

        List<User> list = new ArrayList<>();
        list.add(user);
        User user1 = new User("历史", 20);
        list.add(user1);
        request.setAttribute("list", list);

        Map<String, User> map = new HashMap<>();
        map.put("user", user);
        map.put("user1", user1);
        request.setAttribute("map", map);
    %>
    <h3>获取域对象中简单值</h3>
    ${requestScope.name}<br/>
    ${sessionScope.name}

    <h3>获取对象的值</h3>
    ${sessionScope.user}<br/>
    ${sessionScope.user.name}

    <h3>获取list</h3>
    ${requestScope.list}<br/>
    ${requestScope.list[1].name}

    <h3>获取map</h3>
    ${requestScope.map["user1"]}<br/>
    ${requestScope.map["user1"].name}<br/>
    ${requestScope.map.user1}<br/>
    ${requestScope.map.user1.name}<br/>

    <h2>隐式对象</h2>
    虚拟目录：${pageContext.request.contextPath}
</body>
</html>
