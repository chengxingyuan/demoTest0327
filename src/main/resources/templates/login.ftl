<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录大学生论坛</title>
    <link rel="shortcut icon" href="static/images/bitbug_favicon%20(7).ico" >
    <link rel="stylesheet" type="text/css" href="static/css/login.css"/>
    <script src="static/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="static/js/login.js"></script>

</head>

<body onkeydown="keyLogin(event);">
<div id="register">

    <h1>还没有账号？</h1>
    <p>加入大学生论坛，一起做个文化人！</p>
    <div id="div_btn_register"><input type="button" id="btn_register" value="立即注册"/></div>
</div>


<div id="login">

    <div id="image_logo"><img src="static/images/fly_icon.png"></div>

    <div id="loginForm">
        <form method="post" action="static/js/login.js">

            <div id="div_username"><input type="text" id="username" class="text_field" placeholder="请输入账号"/></div>

            <div id="div_password"><input type="password" id="password" class="text_field" placeholder="请输入密码"/></div>

            <div id="div_forget"><a id="forget_pwd" href="forget_pwd.html" target="_blank">忘记密码？</a></div>

            <div id="div_btn_login"><input type="button" id="btn_login" value="马上登录"  /></div>

        </form>
    </div>

</div>
</body>
</html>