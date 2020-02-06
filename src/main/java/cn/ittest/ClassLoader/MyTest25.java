package cn.ittest.ClassLoader;


import java.sql.SQLOutput;

/**
 * 设置 ---- 线程上下文类加载器
 * @author YJ Lan
 * @create 2020-01-31-13:33
 */
/*

 */
public class MyTest25 implements Runnable{


    private Thread thread;

    public MyTest25(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader contextClassLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(contextClassLoader);

        System.out.println("Class: " + contextClassLoader.getClass());
        System.out.println("Parent: " + contextClassLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }


}
