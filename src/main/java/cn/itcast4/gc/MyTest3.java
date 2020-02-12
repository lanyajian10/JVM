package cn.itcast4.gc;

/**
 * MaxTenuringThreshold=3       经历最大GC次数，年龄超过这个值，Survivor对象放入年老代
 * TargetSurvivorRatio=60       Survivor内存占满60% 重新计算年龄限额，超过这个年龄的都放入年老代。
 * PrintTenuringDistribution    显示每个年龄数据
 *
 * 阈值（年龄限额）：不超过最大值，重新计算逻辑：取当前年龄和MAX的最小值
 * @author YJ Lan
 * @create 2020-02-12-11:16
 */
public class MyTest3 {

    public static void main(String[] args) throws InterruptedException {

        byte[] b1 = new byte[512 * 1024];
        byte[] b2 = new byte[512 * 1024];

        gc();
        Thread.sleep(1000);
        System.out.println("11111");

        gc();
        Thread.sleep(1000);
        System.out.println("22222");

        gc();
        Thread.sleep(1000);
        System.out.println("33333");

        gc();
        Thread.sleep(1000);
        System.out.println("44444");

        byte[] b3 = new byte[1024 * 1024];
        byte[] b4 = new byte[1024 * 1024];
        byte[] b5 = new byte[1024 * 1024];
        gc();
        Thread.sleep(1000);
        System.out.println("55555");
        gc();
        Thread.sleep(1000);
        System.out.println("66666");

    }

    public static void gc(){
        for (int i=0; i<40; i++) {
            byte[] bytes = new byte[1024 * 1024];
        }
    }
}
