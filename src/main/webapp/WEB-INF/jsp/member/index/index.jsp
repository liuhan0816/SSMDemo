<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.arthur.web.core.user.service.UserTokenService"%>
<%@ page import="com.arthur.web.core.user.model.UserSession"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ include file="../../inc.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="stylesheet" href="<%=basePath%>/css/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="<%=basePath%>/css/main.css" media="all" />
	<link rel="stylesheet" href="<%=basePath%>/css/index.css" media="all" />
	<script src="<%=basePath%>/js/jquery.util.js"></script>
	<script src="<%=basePath%>/js/javascript.util.js"></script>
	<script src="<%=basePath%>/js/layui.util.js"></script>
	<script src="<%=basePath%>/js/index.js"></script>
	<title>SSM后台管理系统</title>
</head>
<%
	UserTokenService userTokenService = new UserTokenService(request,response);
	UserSession userSession = userTokenService.getUserSession();
%>
<body class="main_body">
<div class="layui-layout layui-layout-admin">
	<!-- 顶部 -->
	<div class="layui-header header">
		<div class="layui-main">
			<a href="member/index" class="logo" style="font-size:16px;font-weight:600;">任务管理系统</a>
			<!-- 显示/隐藏菜单 -->
			<a href="javascript:;" class="iconfont hideMenu icon-menu1"></a>
			<!-- 顶部右侧菜单 -->
			<ul class="layui-nav top_menu">
				<li class="layui-nav-item">
					<a href="javascript:;">
						<img src="<%=basePath%>/images/face.jpg" onerror="javascript:this.src='<%=basePath%>/images/face.jpg'"
							 class="layui-circle userIconAs" width="35" height="35">
						<cite class="userNameAs">欢迎您：<%=userSession.getUserName()%>！</cite>
					</a>
				</li>
				<li class="layui-nav-item">
					<a href="<%=basePath%>/logout?filename=<%=basePath%>/" class="signOut"><i class="iconfont icon-loginout"></i> 退出</a>
				</li>
			</ul>
		</div>
	</div>
	<!-- 左侧导航 -->
	<div class="layui-side layui-bg-black">
		<!-- <div class="user-photo">
            <a class="img" title="我的头像"><img src="/images/face.jpg" class="userIconAs" onerror="javascript:this.src='/images/face.jpg'"></a>
            <p>你好！<strong><span class="userName userNameAs">admin</span></strong>, 欢迎登录</p>
        </div> -->
		<div class="navBar layui-side-scroll"></div>
	</div>
	<!-- 右侧内容 -->
	<div class="layui-body layui-form">
		<div class="layui-tab marg0" lay-filter="bodyTab" id="top_tabs_box">
			<ul class="layui-tab-title top_tab" id="top_tabs">
				<li class="layui-this" lay-id=""><i class="layui-icon">&#xe68e;</i> <cite>主页</cite></li>
			</ul>
			<ul class="layui-nav closeBox">
				<li class="layui-nav-item">
					<a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#xe669;</i>
							刷新当前</a></dd>
						<dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i>
							关闭其他</a></dd>
						<dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i>
							关闭全部</a></dd>
					</dl>
				</li>
			</ul>
			<div class="layui-tab-content clildFrame">
				<div class="layui-tab-item layui-show">
					<iframe src="<%=basePath%>/member/home"></iframe>
				</div>
			</div>
		</div>
	</div>
</div>

<script>


	(function () {
		if (getIsWeb() === false) {
			alert('建议在web服务容器中打开此网页，如iis、Apache Tomcat、Nginx、node server等。当前状态下被限制了很多功能。');
		}

		pageKeepTop();
	}());

	$(function () {
	});
</script>

</body>

</html>