package com.zhuandian.androidstudy.activity.proxy_activity.proxy;

import com.zhuandian.androidstudy.activity.proxy_activity.dao.UserDao;

/**
 * desc :借助代理对象，判断被传入的user对象是否有权限操作保存数据
 * author：xiedong
 * date：2019/11/14
 */
public class UserDaoProxy implements UserDao {
    //接收保存目标对象
    private UserDao target;

    public UserDaoProxy(UserDao userDao) {
        this.target = userDao;
    }

    @Override
    public void save(String name) {
        if ("xiaoming".equals(name)) {
            target.save(name);//执行目标对象的方法
            System.out.println("保存成功"+name);
        }else {
            System.out.println("保存失败，无权限操作"+name);
        }

    }
}


/**
 * 我们为什么要引入java的代理，除了当前类能够提供的功能外，我们还需要补充一些其他功能。
 * 最容易想到的情况就是权限过滤，我有一个类做某项业务，但是由于安全原因只有某些用户才可以调用这个类
 * 此时我们就可以做一个该类的代理类，要求所有请求必须通过该代理类，由该代理类做权限判断，如果安全则调用实际类的业务开始处理。
 * 可能有人说为什么我要多加个代理类？我只需要在原来类的方法里面加上权限过滤不就完了吗？
 * 在程序设计中有一个类的单一性原则问题，这个原则很简单，就是每个类的功能尽可能单一。为什么要单一，因为只有功能单一这个类被改动的可能性才会最小。
 * 如果你将权限判断放在当前类里面，当前这个类就既要负责自己本身业务逻辑、又要负责权限判断，那么就有两个导致该类变化的原因，现在如果权限规则一旦变化，
 * 这个类就必需得改，显然这不是一个好的设计。
 */