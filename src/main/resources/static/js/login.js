
function keyLogin(event) {

    var browser = navigator.appName;
    var userAgent = navigator.userAgent;
    var code;
    if(browser.indexOf('Internet')>-1) //IE
    code = window.event.keyCode;
    else if(userAgent.indexOf("Firefox")>-1)  //火狐
    code = event.which;
    else  //其它浏览器
    code = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

    if ( code == 13)  //按Enter键的键值为13
        document.getElementById("btn_login").click();  //调用登录按钮的登录事件
}


window.onload = function () {
    var btn_login = document.getElementById('btn_login');
    var btn_register = document.getElementById('btn_register');


    btn_login.onclick = function login() {
        var user = {};
        user.userId = document.getElementById("username").value;
        user.passWord = document.getElementById("password").value;
        $.ajax({
            url: '/cxy/user/loginAccount',
            type: 'POST',
            //dataType: '',
            data: user,
            success: function(resp){
                var code = resp.code;
                var mes = resp.message;
                if (code == '00'){
                    window.location.href = "index";
                }else {
                    alert(mes);
                }
            },
            error: function(){
                alert("服务器响应出错，请稍后再试！或联系网站管理员");
            }
        })
        


        // if (username.value == "") {
        //
        //     alert("请输入用户名");
        //
        // } else if (pass.value == "") {
        //
        //     alert("请输入密码");
        //
        // } else if (username.value == "admin" && pass.value == "123456") {
        //
        //     window.location.href = "welcome.html";
        //
        //     ////  全屏方法
        //     //function fullScreen(element) {
        //     //    if (element.requestFullscreen) {
        //     //        element.requestFullscreen();
        //     //    } else if (element.mozRequestFullScreen) {
        //     //        element.mozRequestFullScreen();
        //     //    } else if (element.webkitRequestFullscreen) {
        //     //        element.webkitRequestFullscreen();
        //     //    } else if (element.msRequestFullscreen) {
        //     //        element.msRequestFullscreen();
        //     //    }
        //     //}
        //     ////  再让当前页面全屏
        //     //fullScreen(document.documentElement);
        //
        // } else {
        //
        //     alert("请输入正确的用户名和密码！");
        //
        // }

    }


    btn_register.onclick = function register() {
        window.open("register.html");
    }
}


