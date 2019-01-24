package com.sunyx.dao;

import com.sunyx.domain.User;

/**
 * Created by liuli on 2019/1/17.
 */
public interface UserDao {
    public void save();
    public User findByName(String userName);
}
