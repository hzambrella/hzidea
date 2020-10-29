package com.hz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class LogJDKProxy {
    //不加final 1.8一下报错
    public static Object getProxy(final Object obj){
        ClassLoader loader=obj.getClass().getClassLoader();
        Class<?>[] interfaces=obj.getClass().getInterfaces();
        InvocationHandler invocationHandler=new InvocationHandler(){

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[Class:]"+proxy.getClass().getName()+"[Method:]"+method.getName()+" args:"+Arrays.toString(args));
                Object result=method.invoke(obj,args);
                System.out.println("[result:]"+result);

                return result;
            }
        };
        return Proxy.newProxyInstance(loader,interfaces,invocationHandler);
    }

    public static  void main(String[] args){
        Caculator caculator=new MyCaculator();
        Caculator caculatorEnhance= (Caculator) LogJDKProxy.getProxy(caculator);
        System.out.println(caculatorEnhance.add(1,1));
        System.out.println(caculatorEnhance);
    }
}
