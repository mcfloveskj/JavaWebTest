<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>登录</TITLE>
<%@include file="/pages/common/common.jsp"%>
<META content="text/html; charset=UTF-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/login.css" media=screen>
<script type="text/javascript" src="scripts/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="scripts/login.js"></script>
</HEAD>
<BODY id=loginFrame>
	<DIV id=header>
		<DIV id=logo>
			<A title="MyProject" href="javascript:void(0)"></A>
		</DIV>
	</DIV>
	<DIV id=loginBox>
		<DIV id=loginBoxHeader></DIV>
		<DIV id=loginBoxBody>
			<UL class=floatLeft>
				<LI>
					<H4>请用您的注册账号登录</H4>
				</LI>
				<FORM id="login" method="post" action="">
					<LI>
						<P>帐号:</P> <INPUT id=username class=textInput maxLength=150
						size=30 type=text name=email>
					</LI>
					<LI>
						<P>密码:</P> <INPUT id=password class=textInput maxLength=80 size=30
						type=password name=password>
					</LI>
					<LI class=highlight><INPUT id=loginBtn value=登录 type=button>
						<font color="red" id="errorIDorPWD"></font></LI>
					<LI></LI>
				</FORM>
			</UL>
			<DIV class=floatRight>
				<div class="right">
					今天是 <font id="dd"></font>
					<br /><br />
					欢迎使用本工具
					<br /> <br /> <br /> <br /> <br /> <br /> <br />
					Designed by <a href="mailto:793061889@qq.com" target="_blank">Cloak</a> In Inner Mongolia
				</div>
			</DIV>
			<BR clear=all>
		</DIV>
		<DIV id=loginBoxFooter></DIV>
	</DIV>

</BODY>
</HTML>
