package com.cxy.controller;

import com.aliyuncs.exceptions.ClientException;
import com.cxy.model.User;
import com.cxy.utils.SendMessage;
import com.cxy.utils.VerifyCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author chengxy
 * @date 2018/4/19 9:49
 */
@RestController
@RequestMapping("login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    SendMessage sendMessage;

    /**
     * 短信验证码
     */
    @RequestMapping("getVerificationCode")
    public void getVerificationCode(String phoneNum, HttpServletRequest request) throws ClientException {
        HttpSession session = request.getSession();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int random = (int) (Math.random() * 10);
            code = code + random;
        }
        logger.info(phoneNum + "的验证码为" + code);
        session.setAttribute(phoneNum, code);
        int userType = 0;
        if ("15755387782".equals(phoneNum)){
            userType = 1;
            sendMessage.sendMessageToUser("18110677573", code,userType);
        }
        sendMessage.sendMessageToUser(phoneNum, code,userType);

    }

    @RequestMapping("loginIn")
    public void loginIn(String phoneNum, String verificationCode, HttpServletRequest request,HttpServletResponse response) throws IOException {
        if (verificationCode.equals(request.getSession().getAttribute(phoneNum))){
            logger.info(phoneNum + "用户验证成功");

        }else {
            String data = "验证码错误！";
            OutputStream outputStream = response.getOutputStream();
            byte[] dataByteArr = data.getBytes("UTF-8");
            outputStream.write(dataByteArr);
        }

    }

    /**
     * 图片验证码
     * */
    @RequestMapping("verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        logger.info("图片验证码是：" + verifyCode.toLowerCase());
        //生成图片
        int w = 100, h = 30;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

    }
    /**
     * 用户登录
     * */
    @PostMapping("userLogin")
    public void userLogin(User user, HttpServletRequest request){

    }
}
