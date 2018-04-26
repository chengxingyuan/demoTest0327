//package com.cxy.utils;
//
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//
//import java.io.Serializable;
//
///**
// * @author chengxy
// * @date 2018/4/25 17:26
// */
//public class UserContext implements Serializable {
//
//    /**
//     * 获取当前线程绑定的用户登录对象
//     *
//     * @return
//     */
//    public static LoginEntity getUserSession() {
//        return (LoginEntity) RequestContextHolder.getRequestAttributes().getAttribute(Constant.LOGINED_KEY,  RequestAttributes.SCOPE_REQUEST);
//    }
//
//    /**
//     * 将用户登录对象绑定到当前线程
//     *
//     * @param loginEntity
//     */
//    public static void setUserSession(LoginEntity loginEntity) {
//        RequestContextHolder.getRequestAttributes().setAttribute(Constant.LOGINED_KEY, loginEntity, RequestAttributes.SCOPE_REQUEST);
//    }
//
//    /**
//     * 将用户登录对象从当前线程销毁
//     */
//    public static void removeUserSession() {
//        RequestContextHolder.getRequestAttributes().removeAttribute(Constant.LOGINED_KEY,RequestAttributes.SCOPE_REQUEST);
//    }
//
//}
