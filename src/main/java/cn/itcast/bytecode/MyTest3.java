package cn.itcast.bytecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * 字节码异常处理
 * @author YJ Lan
 * @create 2020-02-06-13:46
 */
/*
    this关键字

    对于Java类中的每一个实例方法（非static方法），在其编译后生成的字节码文件中，方法参数的数量总会比源代码中方法
    参数的数量多一个（this），它位于方法的第一个参数位置处；这样，我们就可以在Java的实例方法中使用this关键字来访问
    当前对象的属性及其方法。

    这个操作实在编译期间完成的，即由java编译器在编译的时候将对this的访问转化为一个对普通实例方法参数的访问；接下来在运行期间，
    由JVM在调用实例方法的时候，自动向实例方法传入该this参数，所以，在实例方法的局部变量表中，至少会有一个指向当前对象的局部变量。
 */
/*
    Java字节码对于异常的处理方式：

    1.统一采取异常表的方式来对异常进行处理。
    2.在JDK 1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式。
    3.当一场存在finally语句块时，现代的JVM采取的处理方式是将finally语句块的字节码拼接到每一个catch块后面，
      换句话说，程序中存在多少个catch块，就会在每一个catch块后面重复多少个finally语句块的字节码。
 */

public class MyTest3 {

    public void test() throws ClassNotFoundException, FileNotFoundException{
        try {
            FileInputStream is = new FileInputStream(new File("1.text"));

            ServerSocket serverSocket = new ServerSocket();

            serverSocket.accept();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
