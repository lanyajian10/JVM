package cn.itcast1.ClassLoader;

import java.lang.reflect.Method;

/**
 * @author YJ Lan
 * @create 2020-01-31-20:24
 */
/*
    问题：
    如果使用MyTest16自定义类加载器加载MyPerson
    那么  1. (aClass1 == aClass2   false
          2. Caused by: java.lang.ClassCastException:
          MyPerson cannot be cast to MyPerson


    同一命名空间内的类是相互可见的
    如果两个加载器之间没有直接或者间接的父子关系，那么他们各自加载的类相互不可见
 */
/*
    引出： 类加载器的双亲委托模型的好处

    1.可以确保Java核心库的类型安全，所有的Java应用都至少会引用java.lang.Object类，也就是说在运行期，Java.lang.Object这个类
      会被加载到Java虚拟机中，如果这个过程是由Java应用自己的类加载器所完成的，那么很可能就会在JVM中存在多个版本的java.lang.Object
      类，并且这些类之间是不兼容的，相互不可见的（正是命名空间在发挥着作用）
      借助于双亲委托机制，Java核心类库中的类的加载工作都是由启动类加载器统一完成的，从而确保了Java应用所使用的都是同一个版本的Java
      核心类库，他们之间是相互兼容的。
    2.可以确保Java核心类库所提供的类不会被自定义的类加载器所替代。
    3.不同的类加载器可以为相同名称（binary name）的类创建额外的命名空间，相同名称的类可以并存在Java虚拟机中，只需要用不同的类加载器
      来加载他们即可，不同类加载器所加载的类之间是不兼容的，这就相当于在JVM内部创建了一个又一个相互隔离的Java类空间，这类技术在很多
      框架中得到了很好的利用。
 */

public class MyTest21 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("C:/Users/Administrator/Desktop/");
        loader2.setPath("C:/Users/Administrator/Desktop/");

        Class<?> aClass1 = loader1.loadClass("cn.itcast1.ClassLoader.MyPerson");
        Class<?> aClass2 = loader2.loadClass("cn.itcast1.ClassLoader.MyPerson");

        System.out.println(aClass1 == aClass2);

        Object obj1 = aClass1.newInstance();
        Object obj2 = aClass2.newInstance();

        Method setMyPerson = aClass1.getMethod("setMyPerson", Object.class);
        setMyPerson.invoke(obj1, obj2);
    }
}
