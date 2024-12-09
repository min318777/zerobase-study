<%@ page import="db.WifiService" %>
<%@ page import="test.WifiInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="db.Wifi" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        .table-css {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>근처 와이파이 정보</h1>
<nav>
    <a href="home.jsp">홈</a> |
    <a href="history.jsp">위치 히스토리 목록</a> |
    <a href="openApi.jsp">Open API 와이파이 정보 가져오기</a>
</nav>
<form action="result.jsp" method="post">

    LAT: <input type="text" name="latitude" value=<%=request.getParameter("latitude")%>> ,
    LNT: <input type="text" name="longitude" value=<%=request.getParameter("longitude")%>>
    <button type="button" onclick="setCoordinates()">내 위치 가져오기</button>
    <button type="submit" onclick="redirect()" >근처 WIFI 정보 보기</button>
</form>
<table>
    <thead>
    <tr class="table-css">
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    </thead>
    <tbody>
    <%

        String lat = request.getParameter("latitude");
        String lon = request.getParameter("longitude");

        if (lat != null && lon != null) {
            WifiInfo wifiInfo = new WifiInfo();
            List<Wifi> wifiList = wifiInfo.wifiList(lat, lon);

            if (wifiList.isEmpty()) {
    %>
    <tr>
        <td colspan="17">근처 와이파이 정보가 없습니다.</td>
    </tr>
    <%
    } else {
        for (Wifi wifi : wifiList) {
    %>
    <tr>
        <td><%= wifi.getDistance() %></td>
        <td><%= wifi.getMaintenanceNumber() %></td>
        <td><%= wifi.getGu() %></td>
        <td><%= wifi.getName() %></td>
        <td><%= wifi.getAddress1() %></td>
        <td><%= wifi.getAddress2()%></td>
        <td><%= wifi.getFloor() %></td>
        <td><%= wifi.getType() %></td>
        <td><%= wifi.getIs() %></td>
        <td><%= wifi.getSv() %></td>
        <td><%= wifi.getNetwork() %></td>
        <td><%= wifi.getYear() %></td>
        <td><%= wifi.getInOut() %></td>
        <td><%= wifi.getRemars3() %></td>
        <td><%= wifi.getLat() %></td>
        <td><%= wifi.getLon() %></td>
        <td><%= wifi.getWorkDttm() %></td>

    </tr>
    <%
            }
        }
    } else {
    %>
    <tr>
        <td colspan="17">위치 정보가 전달되지 않았습니다.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
