package cn.gxnu.service.imp;
import cn.gxnu.dao.ProvinceTrafficsDAO;
import cn.gxnu.entity.Provincetraffics;
import cn.gxnu.service.Iprovincetraffics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvincetrafficsService implements Iprovincetraffics {

    ProvinceTrafficsDAO conn= new ProvinceTrafficsDAO();
    //添加
    public void Add(Provincetraffics provincetraffics) {
        try {
         conn.add(provincetraffics);
        } catch (SQLException throwables) {
            System.out.println("连接数据库错误");
        }
    }
    //删除
    public void DeletebyId(int id) {
        try {
            conn.delete(id);
        } catch (SQLException throwables) {
            System.out.println("连接数据库错误");

        }

    }
    //修改
    public void Updata(Provincetraffics provincetraffics) {

        try {
            conn.update(provincetraffics);
        } catch (SQLException throwables) {
            System.out.println("连接数据库错误");
        }

    }

    //查询某个时间
    public List<Provincetraffics> FindB(String createtime) {

        List<Provincetraffics> list=new ArrayList<Provincetraffics>();
        try {
            list=conn.find(createtime);
        } catch (SQLException throwables) {
            System.out.println("pro1 service层错误");
        }
        return list;
    }
    //查询某时间段
    public List<Provincetraffics> FindA(String a,String b) {

        List<Provincetraffics> list=new ArrayList<Provincetraffics>();
        try {
            list=conn.find(a,b);
        } catch (SQLException throwables) {
            System.out.println("pro service2错误");
        }
        return list;
    }

}
