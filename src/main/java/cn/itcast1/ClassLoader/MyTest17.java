package cn.itcast1.ClassLoader;

/**
 * 命名空间
 * @author YJ Lan
 * @create 2020-01-31-20:03
 */
/*
    关于命名空间的重要说明：

    1.子加载器所加载的类能够访问父加载器所加载的类
    2.父加载器所加载的类不能访问子加载器所加载的类
 */
public class MyTest17 {

    public static void main(String[] args) throws  Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:/Users/Administrator/Desktop/");

        Class<?> aClass = loader1.loadClass("cn.itcast1.ClassLoader.MySimple");

        System.out.println(aClass.hashCode());

        //注：即便不实例化类，也可能会预先加载所需要的类，如果找不到，并不会立即报错，在调用的时候才报错

        //如果不执行此行，那么并不会实例化MySimple对象，即MySimple的构造方法不会被调用
        //因此也不会实例化MyCat对象，即没有对MyCat主动使用，这里就不会加载MyCat Class
        Object o = aClass.newInstance();

    }
}
