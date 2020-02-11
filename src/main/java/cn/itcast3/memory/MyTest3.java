package cn.itcast3.memory;

/**
 *  演示栈溢出
 * @author YJ Lan
 * @create 2020-02-08-09:37
 */
/*
    工具
    -Xss：100k   设置栈大小为100k
    jconsole
    jvisualVM
 */
public class MyTest3 {

    private int leng;

    public void test(){

        leng ++;

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) {

        MyTest3 myTest3 = new MyTest3();

        try {
            myTest3.test();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(myTest3.leng);
        }

    }
}
