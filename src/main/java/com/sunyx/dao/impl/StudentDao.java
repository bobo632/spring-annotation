package com.sunyx.dao.impl;


import org.springframework.stereotype.Repository;

/**
 * Created by liuli on 2019/1/18.
 */
@Repository("studentDao")
public class StudentDao {
    public void save() {
        System.out.println("save....");
    }
    public String update() {
        System.out.println("update....");
        return "update";

    }
    public void delete() {
        System.out.println("delete...");
    }
    public void find() {
        System.out.println("find...");
        int i =1/0;
    }
}
