package cn.itcast5.g1;

/**
 *  -verbose:gc
 * -XX:+PrintGCDetails
 * -Xms10m
 * -Xmx10m
 * -XX:+PrintGCDateStamps
 * -XX:+UseG1GC
 * -XX:MaxGCPauseMillis=200 设置GC暂停时间为200ms
 * @author YJ Lan
 * @create 2020-02-16-19:32
 */
public class Mytest1 {
    public static void main(String[] args) {

        int size = 1024 * 1024;

        byte[] b1 = new byte[2 * size];
        byte[] b2 = new byte[2 * size];
        byte[] b3 = new byte[2 * size];
        byte[] b4 = new byte[2 * size];

        System.out.println("hello world");
    }
}
