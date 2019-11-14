package com.zhuandian.androidstudy.activity.proxy_activity.proxy;

import com.zhuandian.androidstudy.activity.proxy_activity.dao.UserDao;

/**
 * desc :
 * author：xiedong
 * date：2019/11/14
 */
public class UserDaoProxy implements UserDao {
    //接收保存目标对象
    private UserDao target;
    public UserDaoProxy(UserDao userDao){
        this.target = userDao;
    }


    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
