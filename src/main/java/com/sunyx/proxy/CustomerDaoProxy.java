package com.sunyx.proxy;

import com.sunyx.dao.CustomerDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liuli on 2019/1/18.
 */
public class CustomerDaoProxy implements InvocationHandler{
    private CustomerDao customerDao;

    public CustomerDaoProxy(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public  CustomerDao createProxy(){
        return (CustomerDao)Proxy.newProxyInstance(customerDao.getClass().getClassLoader(), customerDao.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("save".equals(method.getName())){
            System.out.println("save增强");
        }
        return method.invoke(customerDao,args);
    }
}
