<%@ page import="cn.itcast.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
    <h2>if标签</h2>
    <%
        User user = new User("张三", 20);
        session.setAttribute("user", user);

        request.setAttribute("number", 9);

        List<User> list = new ArrayList<>();
        list.add(user);
        User user1 = new User("李四", 20);
        list.add(user1);
        request.setAttribute("list", list);
    %>
    <c:if test="${not empty sessionScope.get('user')}">
        ${sessionScope.get('user')}
    </c:if>
    <br/>
    <c:if test="${empty sessionScope.get('user1')}">
        数据为空
    </c:if>

    <h2>choose标签</h2>
    <c:choose>
        <c:when test="${requestScope.get('number') == 1}">星期一</c:when>
        <c:when test="${requestScope.get('number') == 2}">星期二</c:when>
        <c:when test="${requestScope.get('number') == 3}">星期三</c:when>
        <c:when test="${requestScope.get('number') == 4}">星期四</c:when>
        <c:when test="${requestScope.get('number') == 5}">星期五</c:when>
        <c:when test="${requestScope.get('number') == 6}">星期六</c:when>
        <c:when test="${requestScope.get('number') == 7}">星期天</c:when>
        <c:otherwise>错误数字</c:otherwise>
    </c:choose>

    <h2>foreach标签</h2>
    <%--

    foreach:相当于java代码的for语句
        1. 完成重复的操作
            for(int i = 0; i < 10; i ++){

            }
            * 属性：
                begin：开始值
                end：结束值
                var：临时变量
                step：步长
                varStatus:循环状态对象
                    index:容器中元素的索引，从0开始
                    count:循环次数，从1开始
        2. 遍历容器
            List<User> list;
            for(User user : list){

            }

            * 属性：
                items:容器对象
                var:容器中元素的临时变量
                varStatus:循环状态对象
                    index:容器中元素的索引，从0开始
                    count:循环次数，从1开始


    --%>
    <c:forEach begin="10" end="20" step="2" var="i">
        ${i}&nbsp;<br>
    </c:forEach>
    <c:forEach items="${requestScope.get('list')}" varStatus="s">
        序号:${s.index}&nbsp${s.current.name}&nbsp;${s.current.age}<br>
    </c:forEach>

</body>
</html>
