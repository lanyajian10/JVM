package cn.ittest.ClassLoader;

/**
 * 线程上下文类加载器--使用
 * @author YJ Lan
 * @create 2020-01-31-10:33
 *
 */
/*
    线程上下文类加载器的一般使用模式（获取 - 使用 - 还原）

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    try{
        Thread.currentThread().setContextClassLoader(ClassLoader targetTccl);
        myMethod();
    } finally {
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    myMethod()里面调用了Thread.currentThread().getContextClassLoader(),获取当前线程的上下文类加载器做某些事情

    如果一个类由加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖类没有被加载过的话）

    ContextClassLoader的作用就是为了破坏Java的类加载委托机制。

    当高层提供了统一的接口让低层去实现，同时又需要在高层加载（或实例化）低层的类时，就必须通过线程上下文类加载器来帮助高层的ClassLoader
    找到并加载该类。

    例如：Java提供统一JDBC的接口规范SPI(Service Provider Interface)，实现由Mysql和Orcale各自负责
    问题：JDBC位于rt.jar 是由BootStrap启动类加载器加载的，
         启动类加载器同时需要加载com.mysql.jdbc.Driver的实现类
         实现类位于classpath下，是AppClassPath加载的目录

    解决：把线程的加载器：AppClassLoader作为线程上下文类加载器，这样当启动类加载JDBC的时候，可以获取到App类加载器去加载所需实现类

 */

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;
public class MyTest26 {

    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()){
            Driver driver = iterator.next();

            System.out.println("driver:"+driver.getClass()
                    + ",loader: "+driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());
    }
}
