package com.sunyx.proxy;

import com.sunyx.dao.impl.StudentDao;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liuli on 2019/1/18.
 */
public class StudentProxy implements MethodInterceptor{
    private  StudentDao studentDao;

    public StudentProxy(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentDao createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(studentDao.getClass());
        enhancer.setCallback(this);
        return (StudentDao)enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if("save".equals(method.getName())){
            System.out.println("save增强");
        }
        return methodProxy.invokeSuper(proxy,objects);
    }

}
