<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type='text/css' />
<title>動態網頁</title>
</head>
<body BGCOLOR="white">
	<jsp:include page="../commons/header.jsp" />
	<h2 align="center">Ch02 處理請求與產生回應</h2>
	<div align="center">

		<table border="1">
			<tr height="52" bgcolor="lightblue" align="center">
				<td width="420"><p align="left" /> 
				控制器方法的各種不同編寫方式<BR>
				<a href="welcome0">
					<font face="verdana" size="3">控制器方法的參數型態為Model，傳回字串物件</font>
				</a><BR>
					
				<a href="welcome1">
					<font face="verdana" size="3">控制器方法沒有參數，傳回ModelAndView物件</font>
				</a><BR>
					
				<a href="welcome2">
					<font face="verdana" size="3">與前一項相同，惟設定視圖邏輯名稱的方式不同</font>
				</a><BR>
				
				<a href="welcome3">
					<font face="verdana" size="3">控制器方法的參數型態為ModelMap，傳回字串物件</font>
				</a><BR>
				
				<a href="welcome4">
					<font face="verdana" size="3">控制器方法的參數型態為Model，傳回字串物件</font>
				</a><BR>
											
				</td>
				<td width="420"><p align="left" />
				多個不同請求對應同一個控制器方法<br>
				<a href="mappings1"><font face="verdana" size="3">請求-1</font></a><BR>
				<a href="mappings2"><font face="verdana" size="3">請求-2</font></a><BR>
					<font face="verdana" size="-2">
						ch02.controller.Ch02Controller#mappings() </font>
				</td>
				
			</tr>
			<tr height="52" bgcolor="lightblue" align="center">
				<td width="420"><p align="left" />
				          讀取瀏覽器送來的請求參數<br> 
					<a href="lottery"><font face="verdana" size="3">經由@RequestParam 例一</font></a><BR>
				</td>
				<td width="420"><p align="left" /> 
					 讀取瀏覽器送來的請求參數<br> 
					<a href="advancedLottery"><font face="verdana" size="3">經由@RequestParam 例二</font></a><BR>
				</td>
				
			</tr>
			<tr height="52" bgcolor="lightblue" align="center">
				<td width="420"><p align="left" /> 
					讀取瀏覽器送來的路徑變數<br> 
					<a href="pathVariableLottery"><font face="verdana" size="3">經由@PathVariable 例一</font></a><BR>
				</td>
				<td width="350"><p align="left" />
					讀取瀏覽器送來的路徑變數<br> 
					<a href="advancePathVariableLottery"><font face="verdana" size="3">經由@PathVariable 例二</font></a><BR> 
					<font face="verdana" size="-2"></font>
				</td>
			</tr>

			<tr height="52" bgcolor="lightblue" align="center">
				<td width="350"><p align="left" />
				          控制器方法傳回ModelAndVew物件<br> 
					<a href="cityTime"><font face="verdana" size="3">世界主要城市的時間</font></a><BR>
					
				</td>
				<td width="350"><p align="left" />
				      控制器方法使用Servlet原生的API<br>
				 <a href="nativeServletApi"><font face="verdana" size="3">傳送隨機圖片</font></a><BR>
				</td>
			</tr>
			
			<tr height="52" bgcolor="lightblue" align="center">
				<td width="350"><p align="left" /> <a href=".">控制器內的預設方法</a><BR>
					</td>
				<td width="350"><p align="left" /> <BR>
					</td>
			</tr>
		</table>
	</div>
	<hr>
	<jsp:include page="../commons/footer.jsp" />
</body>
</html>
