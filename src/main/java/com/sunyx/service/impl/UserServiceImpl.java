package com.sunyx.service.impl;

import com.sunyx.dao.UserDao;
import com.sunyx.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by liuli on 2019/1/17.
 */
@Service("userService" )
@Scope("prototype")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Resource(name="userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }
}
