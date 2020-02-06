package cn.ittest.ClassLoader;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author YJ Lan
 * @create 2020-01-31-09:33
 */
public class MyTest27 {

    public static void main(String[] args) throws Exception {
        System.out.println("------------"+MyTest27.class.getClassLoader());

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/day18",
                        "root", "root");

    }
}
