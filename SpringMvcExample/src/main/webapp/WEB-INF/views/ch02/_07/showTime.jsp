<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, java.text.*" %>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<meta charset="UTF-8">
<title>顯示當地時間</title>
</head>
<body>
 <p/>
${now}<br>
<hr>
本範例的重點為控制器方法傳回值的型態為ModelAndView<br>

<p/>
<jsp:include page="../../commons/previousPage.jsp" />
</body>
</html>
<!--      ch01\hello.jsp    -->