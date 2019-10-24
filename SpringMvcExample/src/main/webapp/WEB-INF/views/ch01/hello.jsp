<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
    
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />

<meta charset="UTF-8">
<title>Hello, World! 大家好(Spring MVC版)</title>
</head>
<body> 
<H3>Hello, World! 大家好(Spring MVC版)</H3>
<p/>
<font size='-1'>
本回應由 /WEB-INF/views/ch01/hello.jsp送出，沒有任何Model資料<br>
</font>
<jsp:include page="../commons/previousPage.jsp" />
</body>
</html>
<!--      ch01\hello.jsp    -->