<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
    <h1>와이파이 정보 구하기</h1>
    <nav>
        <a href="home.jsp">홈</a> |
        <a href="history.jsp">위치 히스토리 목록</a> |
        <a href="openApi.jsp">Open API 와이파이 정보 가져오기</a>
    </nav>
    <form action="process.jsp"method="post">
        LAT: <input type="text" name="latitude" value="0.0"> ,
        LNT: <input type="text" name="lontitud" value="0.0">
        <button type="button">내 위치 가져오기</button>
        <button type="button">근처 WIPI 정보 보기</button>
    </form>





</body>
</html>