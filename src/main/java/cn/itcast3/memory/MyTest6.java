package cn.itcast3.memory;

/**
 *
 *  jcmd命令   命令行工具
 *
 *  jmc     图形化工具
 * @author YJ Lan
 * @create 2020-02-09-18:06
 */
/*

    jcmd （从JDK1.7开始增加的命令）

    1.jcmd pid VM.flags:查看JVM的启动参数。
    2.jcmd pid help：列出当前运行的java进程可以执行的操作。
    3.jcmd pid help JFR.dump: 查看具体命令JFR.dump的选项。
    4.jcmd pid PerfCounter.print:查看JVM性能相关参数。
    5.jcmd pid VM.uptime 查看进程运行时间。
    6.jcmd pid GC.class_histogram:查看系统中类的统计信息
    7.jcmd pid Thread.print:查看线程堆栈信息
    8.jcmd pid GC.help_dump filename:导出Heap dump文件，导出的文件可以通过jvisualVM查看  filename：生成的路径和文件名：cn.itcast.MyTest.hprof
    9.jcmd pid VM.system_properties:查看JVM属性信息。
    10.jcmd pid VM.version  查看JVM版本
    11.jcmd pid VM.command_line:查看JVM启动的命令行参数信息
    附：jps -l ： 查看所有java进程
 */

/*
    jmap -clstats PID 打印类加载器数据。
    jstat -gc pid
 */
public class MyTest6 {
    public static void main(String[] args) {
        for ( ;; ) {
            System.out.println("Hello world！");
        }
    }
}
