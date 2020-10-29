package com.hz.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogCglibProxy  implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("[Class:]"+o.getClass().getName()+"[Method:]"+method.getName()+" args:"+ Arrays.toString(objects));
        Object result=methodProxy.invokeSuper(o,objects);
        System.out.println("[result:]"+result);
        return result;
    }

    public static void main(String[] args){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(MyCaculatorSub.class);
        enhancer.setCallback(new LogCglibProxy());
        MyCaculatorSub myCaculatorSub=(MyCaculatorSub)enhancer.create();
        myCaculatorSub.sub(1,1);
    }
}
