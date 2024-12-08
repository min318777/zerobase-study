<%@ page import="db.Wifi" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24. 12. 7.
  Time: 오후 4:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>와이파이 정보 구하기</title>
</head>
<body>
    <jsp:include page="index.jsp" />
    <%
        Wifi wifi = new Wifi();
    %>
</body>
</html>
