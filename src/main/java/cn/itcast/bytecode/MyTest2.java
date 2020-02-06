package cn.itcast.bytecode;

/**
 * @author YJ Lan
 * @create 2020-02-04-15:38
 */
public class MyTest2 {

    String str  = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        myTest2.setX(8);

        in = 20;
    }

    public void setX(int x) {
        this.x = x;
    }
    /*
        多个静态代码块和静态变量在编译时会合并为一个
     */
    static {
        System.out.println("11");
    }
    static {
        System.out.println("12");
    }
    static {
        System.out.println("13");
    }
}
