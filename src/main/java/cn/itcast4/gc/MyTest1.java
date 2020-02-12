package cn.itcast4.gc;

/**
 * GC部分参数以及日志讲解
 * @author YJ Lan
 * @create 2020-02-11-11:26
 */
/*
    准备参数：
    -verbose:gc             详细gc日志信息
    -Xms20M                 堆的初始值大小为20M
    -Xmx20M                 堆的最大值大小为20M
    -Xmn10M                 堆中年轻带的大小为10M
    -XX:SurvivorRatio=8     年轻带的Eden:Survivor:Survivor = 8 : 1 : 1   注：不能均分会在这个值附近
    -XX:+PrintGCDetails     gc的详细信息
 */
/*
    Java1.8 默认Parallel垃圾收集器
    结果阐释：
    GC  Scaverge GC （Minor GC），
    Full GC
    PSYoungGen: 针对年轻带的Parallel Scaverge
    ParOldGen：针对年老代的Parallel Old
    Metaspace：原空间

    6137K->728K(9216K): 年轻带回收前占用内存：6137k   回收后 728k   年轻带总内存（90%）：9216k（9M）   有1M不可用，共回收：5409k （可能部分到年老代，部分回收掉）
    6137K->4832K(19456K)：堆会收前占用总内存：6137k   回收后：4832k  堆总内存：19456k --19M

    0.0038913 secs： 这次垃圾回收耗时
 */
/*
    执行结果
    [GC (Allocation Failure) [PSYoungGen: 6137K->728K(9216K)] 6137K->4832K(19456K), 0.0038913 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [Full GC (Ergonomics) [PSYoungGen: 792K->0K(9216K)] [ParOldGen: 6152K->6808K(10240K)] 6944K->6808K(19456K), [Metaspace: 3272K->3272K(1056768K)], 0.0068889 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
     hello world
    Heap
     PSYoungGen      total 9216K, used 2287K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
      eden space 8192K, 27% used [0x00000000ff600000,0x00000000ff83bde0,0x00000000ffe00000)
      from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
      to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     ParOldGen       total 10240K, used 6808K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
      object space 10240K, 66% used [0x00000000fec00000,0x00000000ff2a6358,0x00000000ff600000)
     Metaspace       used 3280K, capacity 4496K, committed 4864K, reserved 1056768K
      class space    used 359K, capacity 388K, committed 512K, reserved 1048576K
 */


/*
    额外注意：
        1.如果生成对象大于阈（yu）值,则无论年轻带是否有内存，都直接在年老代分配空间。
        2.如果年轻代满了，直接在年老代分配空间。
 */
public class MyTest1 {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] b1 = new byte[2 * size];
        byte[] b2 = new byte[2 * size];
        byte[] b3 = new byte[2 * size];
        byte[] b4 = new byte[2 * size];

        System.out.println("hello world");
    }
}
