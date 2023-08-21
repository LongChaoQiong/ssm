package cn.gxnu.service.imp;

import cn.gxnu.dao.PnameTrafficsDAO;
import cn.gxnu.entity.Pnametraffics;
import cn.gxnu.entity.Pnametraffics;
import cn.gxnu.service.Ipnametraffics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PnametrafficsService  implements Ipnametraffics {
    PnameTrafficsDAO conn= new PnameTrafficsDAO();
    //添加
    public void Add(Pnametraffics Pnametraffics) {
        try {
            conn.add(Pnametraffics);
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
    public void Updata(Pnametraffics Pnametraffics) {

        try {
            conn.update(Pnametraffics);
        } catch (SQLException throwables) {
            System.out.println("连接数据库错误");
        }

    }

    //单个某时间
    public List<Pnametraffics> FindB(String createtime) {
        List<Pnametraffics> list = new ArrayList<Pnametraffics>();
        try {
           list= conn.find(createtime);
        } catch (SQLException throwables) {
            System.out.println("pn1 servive1出错了");
        }
        return list;
    }
    //查询某时间段
    public List<Pnametraffics> FindA(String b,String e) {
        List<Pnametraffics> list = new ArrayList<Pnametraffics>();
        try {
            list= conn.findx(b,e);
        } catch (SQLException throwables) {
            System.out.println("pn2 service2出错了");
        }
        return list;
    }

}
