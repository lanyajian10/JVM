package cn.itcast2.bytecode;

/**
 * @author YJ Lan
 * @create 2020-02-10-10:24
 */

/*
    针对于方法调用动态分派的过程，JVM会在类的方法区建立一个虚方法表的数据结构（virtual method table,vtable）。
    针对于invokeinterface指令来说，JVM会建立一个叫做接口方法表的数据结构（interface method table,itable）
 */
public class MyTest7 {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test();
        dog.test();
    }
}

class Animal {

    public void test(){
        System.out.println("animal");
    }
}
class Dog extends Animal{
    @Override
    public void test() {
        System.out.println("Dog");
    }
}