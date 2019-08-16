<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>首页--layui后台管理模板</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link href="<%=request.getContextPath()%>/plugins/layui/css/layui.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/css/font_tnyc012u2rlwstt9.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/css/main.luyun.css" rel="stylesheet" />
    <style>
        .layui-card-body {
            line-height: 30px;
        }
    </style>
</head>

<body class="childrenBody">

<script src="<%=request.getContextPath()%>/js/javascript.util.js"></script>
<script src="<%=request.getContextPath()%>/plugins/jquery-3.4.1/jquery-3.4.1.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
<script src="<%=request.getContextPath()%>/js/layui.util.js"></script>
<div class="layui-fluid">
    <div class="layui-row">
        <fieldset class="layui-elem-field layui-field-title">
            <legend>待办事项</legend>
        </fieldset>
    </div>

    <div class="layui-row">
        <div id="main_Batch" class="panel_box" ashare-power-id="main_Batch">
            <div class="panel col">
                <a href="javascript:;" data-url="../../page/main/Query.html">
                    <div class="panel_icon">
                        <i class="layui-icon" data-icon="&#xe64d;">&#xe64d;</i>
                    </div>
                    <div class="panel_word newMessage">
                        <span id="todo_ocrerr">*</span>
                        <cite>asp.net core</cite>
                    </div>
                </a>
            </div>
            <div class="panel col">
                <a href="javascript:;" data-url="../../page/main/Query.html">
                    <div class="panel_icon" style="background-color: #FF5722;">
                        <i class="layui-icon" data-icon="&#x1006;">&#x1006;</i>
                    </div>
                    <div class="panel_word newMessage">
                        <span id="todo_conflict">*</span>
                        <cite>kafka</cite>
                    </div>
                </a>
            </div>
            <div class="panel col">
                <a href="javascript:;" data-url="../../page/main/Query.html">
                    <div class="panel_icon" style="background-color: #009688;">
                        <i class="layui-icon" data-icon="&#x1007;">&#x1007;</i>
                    </div>
                    <div class="panel_word newMessage">
                        <span id="todo_checkerr">*</span>
                        <cite>Elasticsearch</cite>
                    </div>
                </a>
            </div>
            <div class="panel col">
                <a href="javascript:;" data-url="../../page/main/Query.html">
                    <div class="panel_icon" style="background-color: #5FB878;">
                        <i class="layui-icon" data-icon="&#xe64f;">&#xe64f;</i>
                    </div>
                    <div class="panel_word newMessage">
                        <span id="todo_matcherr">*</span>
                        <cite>MongoDB</cite>
                    </div>
                </a>
            </div>
            <div class="panel col">
                <a href="javascript:;" data-url="../../page/main/Query.html">
                    <div class="panel_icon" style="background-color: #F7B824;">
                        <i class="layui-icon" data-icon="&#xe857;">&#xe857;</i>
                    </div>
                    <div class="panel_word newMessage">
                        <span id="todo_posterr">*</span>
                        <cite>Redis</cite>
                    </div>
                </a>
            </div>
            <div class="panel col">
                <a href="javascript:;" data-url="../../page/main/Query.html">
                    <div class="panel_icon" style="background-color: #2F4056;">
                        <i class="layui-icon" data-icon="&#xe60f;">&#xe60f;</i>
                    </div>
                    <div class="panel_word newMessage">
                        <span id="no_match_bill">*</span>
                        <cite>Linux</cite>
                    </div>
                </a>
            </div>
            <div class="panel col">
                <a href="javascript:;" data-url="../../page/main/Query.html">
                    <div class="panel_icon" style="background-color:#FF3399;">
                        <i class="layui-icon" data-icon="&#xe63f;">&#xe63f;</i>
                    </div>
                    <div class="panel_word newMessage">
                        <span id="todo_comp_null">*</span>
                        <cite>Docker</cite>
                    </div>
                </a>
            </div>
            <div class="panel col">
                <a href="javascript:;" data-url="../../page/main/Query.html">
                    <div class="panel_icon" style="background-color: #990000;">
                        <i class="iconfont icon-text" data-icon="icon-text"></i>
                    </div>
                    <div class="panel_word newMessage">
                        <span id="todo_no_match">*</span>
                        <cite>Gateway</cite>
                    </div>
                </a>
            </div>
        </div>
    </div>

    <div class="layui-row">
        <hr>
    </div>
</div>

</body>

</html>