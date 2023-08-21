package cn.gxnu.entity;

import java.io.Serializable;
/*
*产品日流量类
 */

public class Pnametraffics implements Serializable {
    //属性与表中的对应，编号，产品名，日期
    private int id;
    private String pname;
    private String traffics;
    private String createtime;
    //set/get方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTraffics() {
        return traffics;
    }

    public void setTraffics(String traffics) {
        this.traffics = traffics;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }


    //构造方法

    public Pnametraffics() {}

    public Pnametraffics(int id, String pname, String traffics, String createtime) {
        this.id = id;
        this.pname = pname;
        this.traffics = traffics;
        this.createtime = createtime;
    }
  //由于数据库中的id是自动增长的，所以可以不赋值
    public Pnametraffics(String pname, String traffics, String createtime) {
        this.pname = pname;
        this.traffics = traffics;
        this.createtime = createtime;
    }
    //辅助方法


    @Override
    public String toString() {
        return "Provincetraffics{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", traffics='" + traffics + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
