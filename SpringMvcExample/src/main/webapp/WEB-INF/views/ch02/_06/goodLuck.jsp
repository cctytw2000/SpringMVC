<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>報明牌 2018 04 01</title>
</head>
<body style="background-color: #e1efbb; font-family: verdana; font-size: 15pt;">
<h2>${replyMessage}</h2>
<hr>
<H2>卜籤求明牌</H2>   
${visitName}，您好，<BR>  
您的明牌為：${luckyNumber}
<hr>
<p>
<div align="center">
<small>&lt;&lt;<a href='<c:url value="${header.referer}"/>'>回前頁</a>&gt;&gt;</small>
<small>&lt;&lt;<a href='<c:url value="/ch02/index"/>'>回第二章首頁</a>&gt;&gt;</small>
</div>  
</body>
</html>