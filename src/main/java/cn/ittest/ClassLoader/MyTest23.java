package cn.ittest.ClassLoader;

import sun.misc.Launcher;

/**
 * @author YJ Lan
 * @create 2020-01-31-16:43
 */
public class MyTest23 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        /*
            内建于JVM的启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类，
            当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器以及系统类加载器，
            这块特殊的机器码叫启动类加载器（BootStrap）。

            启动类加载器并不是Java类，而其他类加载器是Java类，
            启动类加载器是特定于平台的机器指令，他负责开启整个加载过程。

            所有类加载器（除了启动类加载器）都被实现为Java类，不过，总有一个组件来加载第一个Java类加载器，从而让整个加载过程都
            能够进行下去，加载第一个纯Java类加载器就是启动类加载器的职责。

            启动类加载器还负责加载jre正常运行所需要的基本组件，这包括java.lang与java.util包中的类等等。
         */

        System.out.println(ClassLoader.class.getClassLoader());
        //扩展类加载器与系统类加载器也是由 启动类加载器所加载的
        System.out.println(Launcher.class.getClassLoader());
        System.out.println("----------");
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
