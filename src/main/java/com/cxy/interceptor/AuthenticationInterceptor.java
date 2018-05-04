package com.cxy.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/24 11:39
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String path = httpServletRequest.getServletPath();
        logger.info("当前拦截路径为，{}", path);
        List<String> ignoreList = new ArrayList<>();
        ignoreList.add("/error");
        ignoreList.add("/user/loginAccount");
        ignoreList.add("/login");
        ignoreList.add("/article/queryArticleByCollege");
        //ignoreList.add("/index");
        ignoreList.add("/user/saveUser");
        //忽略拦截
        if (ignoreList != null && ignoreList.size() > 0){
            for (String ignorePath : ignoreList){
                if (ignorePath.toLowerCase().contains(path.toLowerCase())){
                    logger.info("{}忽略拦截",path);
                    return true;
                }
            }
        }

        HttpSession session = httpServletRequest.getSession(false);
        if (session == null || session.getAttribute("userInfo") == null) {
            //
            logger.info("用户未登陆，请他去登录。");
            //todo 测试环境注释掉
            //httpServletResponse.sendRedirect("/cxy/login");
        }
        logger.info("通过拦截=========================================");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
