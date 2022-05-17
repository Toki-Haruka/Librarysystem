package util;
/*
用于连接数据库测试
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class dbutil {
    private String dbUrl = "jdbc:mysql://localhost:3306/LibraryMG?serverTimezone" +
            "=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false";
    // LibraryMG 是数据库的名字
    private String dbUserName = "root";
    private String dbPassword = "123456";
    private String jdbcName = "com.mysql.cj.jdbc.Driver";


    //要连接的数据库名， 账号及密码，和驱动
    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        System.out.println("connecting.....");
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }
    public void closeCon(Connection con) throws Exception {

        if(con!=null) {

            con.close();
        }
    }

//测试代码

    public static void main(String[] args) {

        dbutil dbUtil=new dbutil();

        try {

            dbUtil.getCon();

            System.out.println("connecting success!");

        } catch (Exception e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

    }
}



