package cn.gxnu.dao;

import cn.gxnu.entity.Pnametraffics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PnameTrafficsDAO extends BaseDAO_DBCP{
    /**
     *  增加每日流量信息
     * @param pnametraffics 根据一个实体对象进行添加操作
     * @return 添加成功返回添加的条数，值大于0
     * @throws SQLException
     */
    public int add(Pnametraffics pnametraffics) throws SQLException {
        //1、2连接数据库
        Connection conn = super.getConnection();
        //3、创建数据操作对象,基于SQL语句,？占位符方式
        String sql = "insert into t_pname_traffics(pname,traffics,createtime) values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置占位符的值，每个占位均有唯一序号，从1递增
        pstmt.setString(2,pnametraffics.getPname());
        pstmt.setString(1,pnametraffics.getTraffics());
        pstmt.setString(3,pnametraffics.getCreatetime());
        //执行添加操作,当对应SQL语句运行成功，会返回执行的记录条数，即该值>0
        int count = pstmt.executeUpdate();
        return count;
    }

    /**
     * 删除省份日流量信息
     * @param id 根据ID删除每日流量信息
     * @return 删除成功，返回值大于0
     * @throws SQLException
     */
    public int delete(int id) throws SQLException {
        //1、2连接数据库
        Connection conn = super.getConnection();
        //3、创建数据操作对象,基于SQL语句,？占位符方式
        String sql = "delete from  t_pname_traffics where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        //执行删除操作,当对应SQL语句运行成功，会返回执行的记录条数，即该值>0
        int count = pstmt.executeUpdate();
        return count;
    }

    /**
     * 修改省份日流量信息
     * @param Pnametraffics 参数部分为改后的数据，通常须携带主键值
     * @return 修改成功返回值大于0
     * @throws SQLException
     */
    public int update(Pnametraffics Pnametraffics) throws SQLException {
        //1、2连接数据库
        Connection conn = super.getConnection();
        //3、创建数据操作对象,基于SQL语句,？占位符方式
        String sql = "update t_pname_traffics set pname=?,traffics=?,createtime=? where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置占位符的值，每个占位均有唯一序号，从1递增
        pstmt.setString(1,Pnametraffics.getPname());
        pstmt.setString(2,Pnametraffics.getTraffics());
        pstmt.setString(3,Pnametraffics.getCreatetime());
        pstmt.setInt(4,Pnametraffics.getId());
        //执行删除操作,当对应SQL语句运行成功，会返回执行的记录条数，即该值>0
        int count = pstmt.executeUpdate();
        return count;
    }


    /**
     * 查询某段时间内的产品量
     * @param b
     * @param e
     * @return返回结果集
     * @throws SQLException
     */
    public  List<Pnametraffics> findx(String b,String e) throws SQLException {
        //创建一集合
        List<Pnametraffics> listPnametraffics = new ArrayList<Pnametraffics>();
        //1、2连接数据库
        Connection conn = super.getConnection();
        //3、创建数据操作对象,基于SQL语句
        String sql = "select pname,sum(traffics) as traffics from t_pname_traffics where createtime between ? and ? group by pname";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置占位符的值，每个占位均有唯一序号，从1递增
        pstmt.setString(1,b);
        pstmt.setString(2,e);
        //4、创建结果集对象（与表结构类似）
        ResultSet rs = pstmt.executeQuery();
        //遍历结果集，每当循环一次，调用一次rx.next(),可以让结果集中的游标指针向下移动一行
        //当移动到结果集末尾时，rs.next（）返回false，结果循环
        while(rs.next()){
            listPnametraffics.add(new Pnametraffics(0,rs.getString("pname"),
                    rs.getString("traffics"),null));
        }
        return listPnametraffics;
    }



    /**
     * 查询某一时间的产品流量
     * @param createtime
     * @return返回结果集
     * @throws SQLException
     */
    public List<Pnametraffics> find(String createtime) throws SQLException {
        //创建一个集合
        List<Pnametraffics> listPnametraffics = new ArrayList<Pnametraffics>();
        //1、2连接数据库
        Connection conn = super.getConnection();
        //3、创建数据操作对象,基于SQL语句
        String sql = "select pname,traffics from t_pname_traffics where createtime=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置站位符
        pstmt.setString(1,createtime);
        //4、创建结果集对象（与表结构类似）
        ResultSet rs = pstmt.executeQuery();
        //遍历结果集，每当循环一次，调用一次rx.next(),可以让结果集中的游标指针向下移动一行
        //当移动到结果集末尾时，rs.next（）返回false，结果循环

        while(rs.next()){


            listPnametraffics.add(new Pnametraffics(0,rs.getString("pname"),
                    rs.getString("traffics"),null));
        }
        return listPnametraffics;
    }


    
}
