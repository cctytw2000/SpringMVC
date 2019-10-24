<%@ page contentType="text/html; charset=UTF-8" session="false"%>
<html> 
<head>   
<link rel='stylesheet' href='css/styles.css'  type="text/css" />
<title>JSP 範例</title>   
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="commons/header.jsp" />	  	

<ul >
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch01/index" >一、Spring MVC程式基本架構</a></li>
  <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch02/index" >二、處理請求與產生回應</a></li>
<%--   <li><a href="<c:out value='${pageContext.request.contextPath}' />/ch03/index" >三、</a> </li> --%>
 
</ul>
<P/>

</body>
</html>