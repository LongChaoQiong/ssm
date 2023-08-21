package cn.gxnu.dao;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 持久层类，用于连接mysql数据库和关闭mysql数据库
 */
public class BaseDAO_DBCP {
    //获取mysql数据库的连接
    public Connection getConnection() throws SQLException {
        Connection conn=null;
        try {
            Properties pro = new Properties();
            //web下连接数据库
            pro.load(BaseDAO_DBCP.class.getClassLoader().getResourceAsStream("/dbcp.properties"));
            //创建数据源对象
            DataSource ds = BasicDataSourceFactory.createDataSource(pro);
            //基于数据源获取一个数据库连接对象（即从DBCP连接池中取出了一个连接对象）
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("从dbcp连接池中获取数据库连接失败");
        }
        return conn;
    }

    //关闭mysql连接
}
