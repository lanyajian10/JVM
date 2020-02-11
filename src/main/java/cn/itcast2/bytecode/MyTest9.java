package cn.itcast2.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YJ Lan
 * @create 2020-02-06-17:53
 */

public class MyTest9 {
    public static void main(String[] args) {
        //修改配置文件，动态代理生成的class文件生成到磁盘中
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealStudent realStudent = new RealStudent();
        Dynamic dynamic = new Dynamic(realStudent);
        Class<?> aClass = realStudent.getClass();
        Student student = (Student)Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), dynamic);
        student.study(10,"兰");
//        student.toString();
    }
}
class Dynamic implements InvocationHandler {

    private Object obj;

    public Dynamic(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("学习前" + method);
        System.out.println(proxy.getClass());

        method.invoke(this.obj, args);

        System.out.println("学习后" + method);
        return null;
    }

}
class RealStudent implements Student{

    @Override
    public void study(int i,String s) {
        System.out.println("学习"+i+s);
    }
}
interface Student{
    void study(int i,String s);
}