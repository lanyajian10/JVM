package cn.itcast3.memory;

/**
 *
 *  死锁
 * @author YJ Lan
 * @create 2020-02-08-10:07
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        Demo1 demo1 = new Demo1();
        new Thread(new ru(demo1, 0),"Thread-A").start();
        new Thread(new ru(demo1, 1),"Thread-B").start();

        System.out.println("开启完成");
    }
}
class ru implements Runnable {

    private Demo1 test4;
    private int i;
    public ru(Demo1 test4,int i){
        this.test4 = test4;
        this.i = i;
    }
    @Override
    public void run() {
        if (i == 1) {
            test4.test1();
        }else{
            test4.test2();
        }
    }
}

class Demo1{

    private Object obj1 = 1;
    private Object obj2 = 2;
    public void test1(){
        synchronized (obj1){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test2();
        }
    }
    public void test2(){

        synchronized (obj2){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test1();
        }

    }
}
