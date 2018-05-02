package com.cxy.utils;

import com.cxy.model.User;

/**
 * @author chengxy
 * @date 2018/4/25 17:26
 * 将用户信息绑定到当前线程，实现随用随取
 */
public class UserContext{

    private static ThreadLocal<User> local = new ThreadLocal<User>();

    /**
     * 设置用户信息
     * @param user
     */
    public static void setUser( User user ) {
        local.set( user );
    }

    /**
     * 获取登录用户信息
     * @return
     */
    public static User getUser() {
        System.out.println( "当前线程：" + Thread.currentThread().getName() );
        return local.get();
    }

    /**
     * 清除当前线程用户信息
     * */
    public static void removeUser(){
        local.remove();
    }

}
