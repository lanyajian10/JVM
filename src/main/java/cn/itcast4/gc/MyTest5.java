package cn.itcast4.gc;

/**
 * CMS无法处理浮动垃圾产生的
 * concurrent mode failure
 * 从而导致一次Full GC的产生
 * -XX:CMSInitiatingOccupancyFraction=90    设定CMS在对内存占用率达到90%的时候开始GC(因为CMS会有浮动垃圾,所以一般都较早启动GC);
 * -XX:+UseCMSInitiatingOccupancyOnly       只是用设定的回收阈值(上面指定的70%),如果不指定,JVM仅在第一次使用设定值,后续则自动调整.
 * @author YJ Lan
 * @create 2020-02-13-11:22
 */
public class MyTest5 {

    public static void main(String[] args) throws InterruptedException {

        int size = 512*1024;

        byte[] b1 = new byte[2*size];
        byte[] a1 = new byte[4*size];
        byte[] b2 = new byte[3*size];
        byte[] a2 = new byte[2*size];
        byte[] a3 = new byte[1*size];
        a1 = null;
        a2 = null;
        a3 = null;
        System.gc();
        for (int i=0; i<5000; i++) {
            a1 = new byte[size];
            a2 = new byte[size];
            a3 = new byte[size];
        }


        Thread.sleep(100000);
        System.out.println("-----");

    }


}
