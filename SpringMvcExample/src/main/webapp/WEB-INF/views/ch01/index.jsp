<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<title>動態網頁</title>
</head>
<body BGCOLOR="white"> 
<jsp:include page="../commons/header.jsp" />
<h2 align="center">Ch01 Spring MVC程式基本架構</h2> 
<div align="center">
  
<table border="1">
  <tr height="52" bgcolor="lightblue" align="center">
    <td  width="420"><p align="left"/>
      <a href="sayHello">Hello, Spring MVC</a><BR>
           <font face="verdana" size="-2"> mvc.examples.controller.Ch01Controller#sayHello() </font>
    </td>
    <td  width="420"><p align="left"/>
      <a href="serverTime">顯示伺服器時間</a><BR>
           <font face="verdana" size="-2"> mvc.examples.controller.Ch01Controller#serverTime() </font>
    </td>
  </tr>  
</table> 
</div>
<hr>
<jsp:include page="../commons/footer.jsp" />
</body>
</html>
