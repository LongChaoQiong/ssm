package cn.gxnu.entity;

import java.io.Serializable;

public class SPnametraffics implements Serializable {
    //属性与表中的对应，编号，用户名，日期
    private int id;
    private String SPname;
    private String traffics;
    private String createtime;
    //set/get方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSPname() {
        return SPname;
    }

    public void setSPname(String SPname) {
        this.SPname = SPname;
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

    public SPnametraffics() {}

    public SPnametraffics(int id, String SPname, String traffics, String createtime) {
        this.id = id;
        this.SPname = SPname;
        this.traffics = traffics;
        this.createtime = createtime;
    }

    public SPnametraffics(String SPname, String traffics, String createtime) {
        this.SPname = SPname;
        this.traffics = traffics;
        this.createtime = createtime;
    }
    //辅助方法


    @Override
    public String toString() {
        return "Provincetraffics{" +
                "id=" + id +
                ", SPname='" + SPname + '\'' +
                ", traffics='" + traffics + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
