<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>報明牌</title>
</head>
<body>
<pre>
${methodSignature}
</pre>
<hr>
<h3>${title}</h3>
${subtitle}



<center>
<small>&lt;&lt;<a href='<c:url value="/ch02/index"/>'>回前頁</a>&gt;&gt;</small>
</center>  
</body>
</html>