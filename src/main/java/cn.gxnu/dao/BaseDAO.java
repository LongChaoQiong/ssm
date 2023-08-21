package cn.gxnu.dao;

import cn.gxnu.util.DATA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//静态导入
import static cn.gxnu.util.DATA.*;

/**
 * 持久层类，用于连接mysql数据库和关闭mysql数据库
 */
public class BaseDAO {
    //获取mysql数据库的连接
    public Connection getConnection() throws SQLException {
        //1、加载mysql8.x驱动
        try {
            Class.forName(MYSQL_OLD_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("切换为mysql8.x驱动");
            try {
                Class.forName(MYSQL_NEW_DRIVER);
            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println("mysql8.x驱动加载失败");
            }
        }

        //获取mysql连接对象
        /**
         * 第一个参数表示数据库的路径名称  jdbc:mysql:// 协议  loclhost表示数据库所有电脑的IP，此处为本机 :3306表示DBMS的端口  /cdn表示数据库名称
         * 第二个参数表示 登录mysql数据库的账号
         * 第二个参数表示 登录mysql数据库的密码
         */
        Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
        return conn;
    }

    //关闭mysql连接
}
