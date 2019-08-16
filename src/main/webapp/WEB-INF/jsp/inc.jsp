<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 使basePath由当前文件路径即xxx/jsp 变为xxx,放在jsp<head></head>里-->
<%--
<base href="<%=basePath%>">
--%>
<!-- 引入jQuery 核心库-->
<script src="<%=basePath%>/plugins/jquery-3.4.1/jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="<%=basePath%>/plugins/layui/css/layui.css" media="all" />
<script src="<%=basePath%>/plugins/layui/layui.js"></script>
<!--

-->