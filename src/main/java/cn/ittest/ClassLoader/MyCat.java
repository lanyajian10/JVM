package cn.ittest.ClassLoader;

/**
 * @author YJ Lan
 * @create 2020-01-31-20:00
 */
public class MyCat {

    public MyCat(){

        System.out.println("MyCat is loaded by :" + this.getClass().getClassLoader());

    }
}
