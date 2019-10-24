<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, java.text.*" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<meta charset="UTF-8">
<title>顯示伺服器的時間</title>
</head>
<body>
 <p/>
伺服器的時間為${now}<br>
<hr>
JSP網頁依然用EL來取得控制器(Controller)送回的資料<br>
<p/>
<font size='-1'>
伺服器時間是由控制器計算出來，存入交由Model再轉交給serverTime.jsp<br>
本回應由 /WEB-INF/views/ch01/serverTime.jsp送出，沒有任何Model資料<br>
</font>
<jsp:include page="../commons/previousPage.jsp" />
</body>
</html>
<!--      ch01\hello.jsp    -->