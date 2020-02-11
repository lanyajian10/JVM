package cn.itcast1.ClassLoader;

import java.io.*;

/**
 * 自定义类加载器
 * @author YJ Lan
 * @create 2020-01-31-16:57
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public void setPath(String path) {
        this.path = path;
    }

    //默认自定义加载器的父加载器为系统类加载器---getSystemClassLoader
    public MyTest16(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    //指定自定义类加载器的双亲
    public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

//    public MyTest16(ClassLoader parent){
//        super(parent);
//    }


    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("-------findClass invoked " + className);

        byte[] data = loadClassData(className);
        return defineClass(className, data, 0, data.length);
    }

    //根据二进制名字取寻找对应的字节码文件
    private byte[] loadClassData(String className){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", "/");
        try {
//            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;

            while (-1 != (ch = is.read())){
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }
    /*

       .loadClass方法自动调用我们重写的findClass方法，而不需要我们自己调用

       AppClassLoader 是 MyTest27的  定义类加载器（真正加载的类加载器）
       AppClassLoader、loader1 是 MyTest27的  初始类加载器
       由于双亲委托机制，在AppClassLoader中可以加载MyTest27，所以由loader1的父类加载MyTest27

       如果想让loader1加载，
       1.那么需要删除APP加载到的路径下的class文件，
       2.并且把响应的字节码文件放到相应的路径中，并设置到path中
    */
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:/Users/Administrator/Desktop/");
        Class<?> aClass = loader1.loadClass("cn.itcast1.ClassLoader.MyTest27");
        System.out.println("class: " + aClass.hashCode());
        Object object = aClass.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
        System.out.println("-----------------");

//        MyTest16 loader2 = new MyTest16(loader1,"loader2");
//        loader2.setPath("C:/Users/Administrator/Desktop/");
//        Class<?> aClass2 = loader2.loadClass("MyTest27");
//        System.out.println("class: " + aClass2.hashCode());
//        Object object2 = aClass2.newInstance();
//        System.out.println(object2);
//        System.out.println(object2.getClass().getClassLoader());
//        System.out.println("-----------------");
//
//
//        MyTest16 loader3 = new MyTest16("loader3");
//        loader3.setPath("C:/Users/Administrator/Desktop/");
//        Class<?> aClass3 = loader3.loadClass("MyTest27");
//        System.out.println("class: " + aClass3.hashCode());
//        Object object3 = aClass3.newInstance();
//        System.out.println(object3);
//        System.out.println(object3.getClass().getClassLoader());
//        System.out.println("-----------------");
    }


}
