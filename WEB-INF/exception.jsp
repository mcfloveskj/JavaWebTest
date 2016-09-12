<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.apache.log4j.Logger,org.apache.commons.logging.LogFactory"%>

<%
	/* Exception ex = (Exception) request
			.getAttribute("javax.servlet.error.exception");
	//记录日志
	Logger logger = LoggerFactory.getLogger("exception.jsp");
	logger.error(ex.getMessage(), ex); */
	
	//ErrorMSG: exception.getMessage()
%>

<!DOCTYPE html>
<html>
<head>
<title>正在跳转...</title>
<script type="text/javascript">
	window.onload = function(){
		var omit = "";
		setInterval(function(){
			omit = omit + ".";
			document.getElementById("omit").innerHTML = omit;
		}, 800);
		setTimeout(function(){
			parent.location.href = "/MyProject/index.do";
		}, 3000);
	};
</script>
</head>

<body>
	<h3>未登录或登陆超时，正在跳转到<a href="/MyProject/index.do">登录界面</a><b id="omit"></b></h3>
</body>
</html>