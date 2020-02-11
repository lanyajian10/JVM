package cn.itcast3.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 方法区产生溢出
 * @author YJ Lan
 * @create 2020-02-08-11:08
 */
/*
    使用依赖cglib动态创建指定类的子类
 */
public class MyTest5 {

    public static void main(String[] args) {
        for (;;) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest5.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) ->
                proxy.invokeSuper(obj, args1));
            System.out.println("hello world");
            enhancer.create();

        }
    }

}
