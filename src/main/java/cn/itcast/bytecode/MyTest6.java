package cn.itcast.bytecode;

/**
 * 方法的动态分派
 * @author YJ Lan
 * @create 2020-02-06-14:22
 */
/*
    方法的动态分派

    方法的动态分派涉及到一个重要概念：方法接收者

    invokevirtual字节码指令的多肽查找流程：

    比较方法重载（Overload）与方法重写（Overwrite），我们可以得到这样的结论：

    方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 */
public class MyTest6 {

    public static void main(String[] args) {
        Fruit apple = new Fruit();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }

}

class Fruit{
    public void test(){
        System.out.println("Fruit");
    }
}
class Apple extends Fruit{
    @Override
    public void test() {
        System.out.println("Apple");
    }
}
class Orange extends Fruit{
    @Override
    public void test() {
        System.out.println("Orange");
    }
}
