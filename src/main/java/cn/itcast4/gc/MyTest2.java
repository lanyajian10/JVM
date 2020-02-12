package cn.itcast4.gc;

/**
 * GC 阈值
 * @author YJ Lan
 * @create 2020-02-11-15:16
 */
/*
    准备参数：
    -verbose:gc             详细gc日志信息
    -Xms20M                 堆的初始值大小为20M
    -Xmx20M                 堆的最大值大小为20M
    -Xmn10M                 堆中年轻带的大小为10M
    -XX:SurvivorRatio=8     年轻带的Eden:Survivor:Survivor = 8 : 1 : 1   注：不能均分会在这个值附近
    -XX:+PrintGCDetails     gc的详细信息
    -XX:PretenureSizeThreshold=5242880    阈值：5M
    -XX:+UseSerialGC        使用串行（单线程）GC作为默认GC
 */
/*
    结果：  5M直接存到年老代中
    Heap
 def new generation   total 9216K, used 2205K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  26% used [0x00000000fec00000, 0x00000000fee27628, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 tenured generation   total 10240K, used 5120K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
   the space 10240K,  50% used [0x00000000ff600000, 0x00000000ffb00010, 0x00000000ffb00200, 0x0000000100000000)
 Metaspace       used 3274K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 359K, capacity 388K, committed 512K, reserved 1048576K
 */
/*
    -XX:PretenureSizeThreshold=5242880    阈值：5M
    -XX:+UseSerialGC        使用串行（单线程）GC作为默认GC
    阈值：
    生成对象大小大于阈值，直接存在年老代
    注：必须配合串行（单线程）GC作为默认GC
 */
public class MyTest2 {
    public static void main(String[] args) {

        byte[] bytes = new byte[5242880];

        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }
}
