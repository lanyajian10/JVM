package cn.itcast2.bytecode;

/**
 * 方法的静态分派
 * @author YJ Lan
 * @create 2020-02-06-14:08
 */
/*
    方法的静态分派

    Grandpa grandpa = new Father();

    以上代码，grandpa的静态类型是Grandpa,而其实际类型（真正的指向类型）是Father

    由此我们可以得出这样一个结论：
    变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多肽的一种体现），实际类型实在运行期方可确定。

 */
public class MyTest5 {

    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }
    public void test(Father father) {
        System.out.println("father");
    }
    public void test(son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa father = new Father();
        Grandpa son = new son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(father);//grandps
        myTest5.test(son);  //grandps
    }
}

class Grandpa{

}
class Father extends Grandpa{

}
class son extends Father{

}