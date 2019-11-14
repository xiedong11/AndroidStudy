package com.zhuandian.androidstudy.activity.proxy_activity.dao;

/**
 * desc :接口实现
 *      目标对象
 * author：xiedong
 * date：2019/11/14
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
