package com.sunyx.proxy;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by liuli on 2019/1/18.
 */
@Aspect
@Component
public class AspectXml {
    /*
    * 前置通知
    * */
    @Before(value="execution(* com.sunyx.dao.impl.StudentDao.save(..))")
    public void check(JoinPoint joinPoint) {
        System.out.println("权限效验" + joinPoint.getSignature().getName());
    }

    /*
   * 后置通知
   * */
    @AfterReturning(value="execution(* com.sunyx.dao.impl.StudentDao.delete(..))",returning = "result")
    public void writeLog(Object result) {
        System.out.println("日志记录" + result);
    }

    /*
   * 环绕通知
   * */
    @Around(value="execution(* com.sunyx.dao.impl.StudentDao.find(..))")
    public Object round(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前通知------");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("环绕后通知------");
        return object;
    }

    /*
  * 异常抛出通知
  * */
    @AfterThrowing(value="execution(* com.sunyx.dao.impl.StudentDao.update(..))",throwing = "ex")
    public void afterThrow(Throwable ex) {
        System.out.println("异常抛出通知---" + ex.getMessage());
    }

    /*
    * 最终通知
    * */
    @After(value="execution(* com.sunyx.dao.impl.StudentDao.update(..))")
    public void after() {
        System.out.println("最终通知---");
    }

}
