package cn.itrast.memory;

import java.util.ArrayList;
import java.util.List;

/**
 *  关于Java创建对象的过程   和 演示堆溢出
 * @author YJ Lan
 * @create 2020-02-07-15:55
 */
/*
    new 关键字创建对象的3个步骤
    1.在堆内存中创建出对象的实例。
    2.为对象的实例成员变量赋初值。<init>
    3.将对象的引用返回。

    在堆内存中创建对象的方式：
    方式1：指针碰撞（前提是堆中的内存空间通过一个指针进行分割，一侧是已经被占用的空间，另一侧是未被占用的空间。）
                 （创建：在未被占用的空间创建一个对象，然后把指针进行移动）
    方式2：空闲列表（前提是堆中的内存空间中以备使用和未被使用的空间交叉存在，这时，虚拟机就通过一个列表来记录哪些空间可用，哪些空间已被使用）
                 （创建：找出可以容纳下新创建对象的且未被使用的空间，在此空间存放该对象，同时还需要更新列表上的记录）

    对象在内存中的布局：

    1.对象头
    2.实例数据（我们在一个类中所声明的各项信息）
    3.对齐填充（可选）

    句柄，指针
    1.句柄形式（引用指向的句柄有两个指针）：  指针1---指向实例数据位置   指针2---指向方法区元数据位置
    2.指针形式（一个指针，更快速）：         包含实例数据              指针 ---指向方法区元数据位置

 */

/*
    演示堆溢出
    -Xms5m  -Xmx5m   设置堆最小最大为5M
    -XX：+HeapDumpOnOutOfMemoryError   堆内存溢出后打印信息
    堆转储
    工具  cmd执行：jvisualvm

 */
public class MyTest2 {

    public static void main(String[] args) {
        List<MyTest2> list = new ArrayList<MyTest2>();

        for (;;) {
            list.add(new MyTest2());
            System.gc();
        }
    }
}
