<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ include file="inc.jsp"%>
<!doctype html>
<html>
<head>
<!-- 使basePath由当前文件路径即xxx/jsp 变为xxx,放在jsp<head></head>里-->
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>SSMDemo项目</title>
<!--
<link href="http://img.eportyun.com/public/huiv1/theme/login/default/css/reset.css" rel="stylesheet" type="text/css">
<link href="http://img.eportyun.com/public/huiv1/theme/login/default/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://img.eportyun.com/public/huiv1/theme/login/javascript/jquery.js"></script>
<script type="text/javascript" src="http://img.eportyun.com/public/huiv1/theme/login/javascript/login.js" ></script>
-->
<link href="<%=basePath%>/theme/login/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>/theme/login/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>/js/login.js" ></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.md5.js"></script>
</head>

<body>
<div class="loginCon">
	<div class="loginBg01"></div>
    <div class="loginBg02">
  			<form class="form form-horizontal" method="post" id="form" action="<%=request.getContextPath()%>/login">
    		<input type="hidden" name="calllogin" value="${calllogin }"/>
    	
	        <div class="login-box">
	            <div class="error-tit" id="loginMessage" style="display:none;"></div>
	            
	            <div class="ban-lgBar ban-user">
	            	<c:choose>
	            		<c:when test="${empty userCode or userCode==''}">
	            			<input type="text" class="inputtext" name="userCode" id="userCode" value="用户名"/>
	            		</c:when>
	            		<c:otherwise>
	            			<input type="text" class="inputtext" name="userCode" id="userCode" value="${userCode }"/>
	            		</c:otherwise>
	            	</c:choose>
	              <i class="lg-arrow-user"></i>
	            </div>
	            <div class="ban-lgBar ban-password">
					<input type="password" id="userPassword" style="display:none"/>
					<input name="userPassword" type="hidden" id="userSign" style="display:none"/>
					<input type="text" id="userPasswordTips" value="密码"/>
					<i class="lg-arrow-password"></i>
	            </div>
	            
	            <div class="ban-lgBar-code">
	              <input name="certificationCode" type="text" class="input-code" id="certificationCode" value="验证码"/>
	              <span class="code-box"><img id="certificationCodeImg" alt="" src="<%=basePath%>/imageCheck" width="90" height="30"></span>
             		<a href="javascript:reloadCertificationCode();" id="kanbuq">换一张</a>
	            </div>
	            <a class="loginBtn" href="javascript:void(0)" onclick="doSubmit();">立即登录</a>
	        </div>
        </form>
    </div>
    <div class="loginBg03"></div>
</div>
<div class="login-copyright">版权所有  @liuhan</div>
</body>
</html>

<script>
writeErrorMsg("${loginMsg}");

document.onkeydown=function(event){
	var e = event || window.event || arguments.callee.caller.arguments[0];            
	if(e && e.keyCode==13){ 
		//按 回车提交        
		doSubmit();
	}                     
}
//重新载入验证码
function reloadCertificationCode(){ 
	window.setTimeout(function(){ document.getElementById("certificationCodeImg").src="<%=request.getContextPath()%>/imageCheck?t="+ Math.random();},100);
	$("#certificationCode").val("");
}

</script>
