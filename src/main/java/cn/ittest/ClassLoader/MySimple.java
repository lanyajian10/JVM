package cn.ittest.ClassLoader;

/**
 * @author YJ Lan
 * @create 2020-01-31-20:02
 */
public class MySimple {

    public MySimple(){

        System.out.println("MySimple is loaded by : " + this.getClass().getClassLoader());

        new MyCat();

        System.out.println("From MySimple : MyCat :" + MyCat.class.getClassLoader());
    }
}
