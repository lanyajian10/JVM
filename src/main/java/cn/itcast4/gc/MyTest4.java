package cn.itcast4.gc;

/**
 * @author YJ Lan
 * @create 2020-02-12-15:56
 */
/*
    -verbose:gc
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:+UseConcMarkSweepGC
    -XX:+PrintTenuringDistribution
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        int size = 1024 * 1024;

        byte[] b1 = new byte[4 * size];

        System.out.println("1111");
        byte[] b8 = new byte[4 * size];


        System.out.println("2222");

        byte[] b88 = new byte[4 * size];
        System.out.println("3333");
//        byte[] b24 = new byte[4 * size];

        Thread.sleep(1000000);
    }
}
