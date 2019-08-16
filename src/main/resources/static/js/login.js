
$(document).ready(function(){
    //输入框焦点
    $("#userCode").focus(function(){
        if($(this).val()=="用户名"){$(this).val("");}
    });
    $("#userCode").blur(function(){
        if($(this).val()==""){$(this).val("用户名");}
    });
    $("#userPassword").focus(function(){
        if($(this).val()=="密码"){$(this).val("");}
    });
    $("#userPassword").blur(function(){
        if($(this).val()==""){
            $(this).hide();
            $("#userPasswordTips").show();
        }
    });

    $("#certificationCode").focus(function(){
        if($(this).val()=="验证码"){$(this).val("");}
    });
    $("#certificationCode").blur(function(){
        if($(this).val()==""){$(this).val("验证码");}
    });

    $("#userPasswordTips").focus(function(){
        $("#userPassword").show();
        $("#userPassword").focus();
        $(this).hide();
    });


});

function doSubmit() {
    var  userCode = document.getElementById("userCode").value;
    var  userPassword = document.getElementById("userPassword").value;

    if($("#userPassword").is(':hidden')){
        userPassword='';
    }

    var  certificationCode=document.getElementById("certificationCode").value;
    if(userCode==""||userCode=='用户名'){
        writeMsg("用户名不能为空!");
    }else if(userPassword==""){
        writeMsg("密码不能为空!");
    }else if(certificationCode==""||certificationCode=="验证码"){
        writeMsg("验证码不能为空!");
    }else{
        //setCookie("uid",userCode,60*60*24*30);
        //密码md5加密填入userSign,清空userPassword
        document.getElementById("userSign").value=$.md5(userPassword);
        document.forms[0].submit();
    }
}

function doMockSubmit() {
    var  userCode = document.getElementById("userCode").value;

    if(userCode==""){
        writeMsg("用户名不能为空!");

    }else{
        //setCookie("uid",userCode,60*60*24*30);

        document.forms[0].submit();
    }
}

//输出出错的信息，并重新载入验证码
function writeErrorMsg(msg){
    writeMsg(msg);
}

//输出提示信息
function writeMsg(msg){
    document.getElementById("loginMessage").innerHTML = msg;
    if(msg!=''){
        document.getElementById("loginMessage").style.display="";
    }
}
//使用回车登录
function fireLogin(){
    if (event.keyCode == 13){
        if(document.getElementById("userPassword")){
            doSubmit();
        }else{
            doMockSubmit();
        }
    }

}

//重置
function reset(){
    document.getElementById("userCode").value="";
    document.getElementById("userPassword").value="";
}
