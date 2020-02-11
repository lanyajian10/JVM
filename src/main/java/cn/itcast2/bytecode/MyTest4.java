package cn.itcast2.bytecode;

/**
 * 栈帧
 * 符号引用，直接引用
 * 静态解析，动态解析
 * @author YJ Lan
 * @create 2020-02-06-13:24
 */
/*
    栈帧（stack frame）

    栈帧是一种 用于帮助虚拟机执行方法调用 与 方法执行 的数据结构。

    栈帧是一种数据结构，封装了方法的局部变量表，动态链接信息，方法的返回地址以及操作数栈等信息。
 */
/*
    符号引用、直接引用----静态解析/动态解析

    有些符号引用是在类加载阶段或是第一次使用时就会转为直接引用，这种转换成为 静态解析

    另外一些符号引用则是在每次运行期转化为直接引用的，这种转换叫做 动态链接，这体现在Java的多态性。

 */
/*
    1.invokeinterface：调用接口中的方法，实际上实在运行期决定的，决定到底调用实现该接口的哪个对象的特定方法。
    2.invokestatic：   调用静态方法。
    3.invokespecial：  调用自己的私有方法、构造方法（<init>）以及父类的特定方法。
    4.invokevirtual：  调用虚方法，运行期查看查找的过程。例如：子类重写父类方法，运行期才能决定多肽调用哪个子类所有方法。
    5.invokedynamic：  动态调用方法。
 */
/*
    静态解析的4种情形：

    1.静态方法
    2.父类方法
    3.构造方法
    4.私有方法

    以上4种方法成为非虚方法，他们是在类加载阶段就可以将符号引用转换为直接引用。
 */

public class MyTest4 {

    public static void test() {
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }
}
