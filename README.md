# README


# **前言**
####    **· 项目环境**
    1. Intellij IDEA 2019.1
    2. java version "1.8.0"
####    **· 项目说明**
    1.该项目为在学习张龙老师的 《深入理解 JVM》 课程，部分代码不完整，会在温习的过程逐步补充，完整代码在笔记中都有所呈现。
    
    本项目分为四部分：
    1.cn.ittest.ClassLoader 文件夹下为 类加载器相关内容
    
    MyTest16 自定义类加载器
    MyTest17 命名空间
    MyTest21 同一命名空间内的类是相互可见的 --->类加载器的双亲委托模型的好处
    MyTest23 类加载器的加载问题
    MyTest24 当前类加载器/线程上下文类加载器
    MyTest25 设置 ---- 线程上下文类加载器Demo
    MyTest26 线程上下文类加载器--使用
    MyTest27 JDBC的类加载器源码分析
    
    2.cn.itcast.bytecode    文件夹下为 字节码文件相关内容学习
    
    MyTest1 字节码练习Demo1
    MyTest2 字节码练习Demo2
    MyTest3 this关键字，字节码异常处理
    MyTest4 符号引用、直接引用----静态解析/动态解析
    MyTest5 方法的静态分派  重载
    MyTest6 方法的动态分派  多肽的重写
    MyTest8 解释执行/编译执行----（栈的指令集 与 基于寄存器的指令集）
    
    3.cn.itrast.memory       文件夹下为 内存空间相关内容
    
    MyTest1 JVM内存空间划分
    MyTest2 Java创建对象的过程和堆溢出     -Xms5m  -Xmx5m  设置堆最小最大为5M
    MyTest3 栈溢出                       工具： jconsole jvisualVM   Xss栈大小参数
    MyTest4 死锁                         工具： jconsole jvisualVM
    MyTest5 方法区产生溢出                工具：依赖cglib
    MyTest6 JVM命令行以及图形化工具        命令jcmd jps jmap jstat  
                                         图形化工具 jmc
    
    4.待补充