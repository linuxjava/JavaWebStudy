<%--
  Created by IntelliJ IDEA.
  User: robincxiao
  Date: 2020/1/20
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%--引入标签--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    我是主体
<%--演示发生错误--%>
<%
    List<Object> objects = new ArrayList<>();
//    objects.get(1);
%>

    <%--注意： page contentType这行代码一定要与include页面中设置的保持一致--%>
    <%@ include file="top.jsp"%>

</body>
</html>
