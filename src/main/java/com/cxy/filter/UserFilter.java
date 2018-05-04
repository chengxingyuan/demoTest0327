package com.cxy.filter;

import com.cxy.model.User;
import com.cxy.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author chengxy
 * @date 2018/5/2 15:46
 */
@WebFilter(filterName = "sessionFilter", urlPatterns = "/*")
public class UserFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(UserFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        //logger.info("当前filterURI是" + request.getRequestURI());
        //登录请求不做处理 静态文件不做处理
        if (request.getRequestURI().contains("/login") || request.getRequestURI().contains("/static/")) {
            chain.doFilter(req, res);
            return;
        }

        HttpSession session = request.getSession();
        //如果session用户信息不为空，将用户信息绑定到当前线程中
        if (session.getAttribute("userInfo") != null) {
            if (UserContext.getUser() == null) {
                UserContext.setUser((User) session.getAttribute("userInfo"));
            }
        }
//        else {
//            //如果session为空 跳转到登录页
//            logger.info("session为空");
//            HttpServletResponse response = (HttpServletResponse) res;
//            response.sendRedirect("/cxy/login");
//            return;
//        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
