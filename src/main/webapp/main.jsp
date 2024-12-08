<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24. 12. 9.
  Time: 오전 1:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>


    <title>Title</title>
    <script>
      function setCoordinates() {
        navigator.geolocation.getCurrentPosition(function (pos) {
          console.log(pos);
          var latitude = pos.coords.latitude;
          var longitude = pos.coords.longitude;

          document.querySelector("input[name='latitude']").value = pos.coords.latitude;
          document.querySelector("input[name='longitude']").value = pos.coords.longitude;
        });
      }
      function redirect(){
          navigator.geolocation.getCurrentPosition(function (pos) {
              console.log(pos);
              var latitude = pos.coords.latitude;
              var longitude = pos.coords.longitude;
              window.location.href = "result.jsp?latitude=" + latitude + "&longitude=" + longitude;
          });
      }
    </script>

</head>
<body>
<h1>와이파이 정보 구하기</h1>
  <nav>
    <a href="home.jsp">홈</a> |
    <a href="history.jsp">위치 히스토리 목록</a> |
    <a href="openApi.jsp">Open API 와이파이 정보 가져오기</a>
  </nav>
  <form action="result.jsp" method="post">
    LAT: <input type="text" name="latitude" value="0.0"> ,
    LNT: <input type="text" name="longitude" value="0.0">
    <button type="button" onclick="setCoordinates()">내 위치 가져오기</button>
    <button type="submit" onclick="redirect()" >근처 WIFI 정보 보기</button>
  </form>

</body>
</html>
