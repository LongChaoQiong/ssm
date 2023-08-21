package cn.gxnu.service.imp;

import cn.gxnu.dao.SPnametrafficsDAO;
import cn.gxnu.entity.Provincetraffics;
import cn.gxnu.entity.SPnametraffics;
import cn.gxnu.entity.SPnametraffics;
import cn.gxnu.service.Ispnametraffics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SPnametrafficsService implements Ispnametraffics {
    SPnametrafficsDAO conn= new SPnametrafficsDAO();
    //添加
    public void Add(SPnametraffics SPnametraffics) {
        try {
            conn.add(SPnametraffics);
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
    public void Updata(SPnametraffics SPnametraffics) {

        try {
            conn.update(SPnametraffics);
        } catch (SQLException throwables) {
            System.out.println("连接数据库错误");
        }

    }

    @Override
    public List<SPnametraffics> FindB(String createtime) {
        List<SPnametraffics> list=new ArrayList<SPnametraffics>();
        try {
            list=conn.find(createtime);
        } catch (SQLException throwables) {
            System.out.println("sp1 service层错误");
        }
        return list;
    }

    @Override
    public List<SPnametraffics> FindA(String b, String e) {

        List<SPnametraffics> list=new ArrayList<SPnametraffics>();
        try {
            list=conn.find(b,e);
        } catch (SQLException throwables) {
            System.out.println("sp2 service层错误");
        }
        return list;
    }



}

