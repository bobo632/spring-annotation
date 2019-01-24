package com.sunyx.dao.impl;

import com.sunyx.dao.CustomerDao;

/**
 * Created by liuli on 2019/1/18.
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save() {
        System.out.println("save....");
    }
    @Override
    public void update() {
        System.out.println("update....");

    }
    @Override
    public void delete() {
        System.out.println("delete...");
    }
    @Override
    public void find() {
        System.out.println("find...");
    }
}
