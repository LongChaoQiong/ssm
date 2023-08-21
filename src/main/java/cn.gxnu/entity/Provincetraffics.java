package cn.gxnu.entity;

import java.io.Serializable;

/**
 * 实体类,通常一个实体类对应数据库中的一个表
 * 实体java.io.Serializabale接口，便于io序列化
 */
public class Provincetraffics implements Serializable {
    //属性与表中的对应，编号，省份，日期
    private int id;
    private String province;
    private String traffics;
    private String createtime;
    //set/get方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setprovince(String province) {
        this.province = province;
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

    public Provincetraffics() {}

    public Provincetraffics(int id, String province, String traffics, String createtime) {
        this.id = id;
        this.province = province;
        this.traffics = traffics;
        this.createtime = createtime;
    }

    public Provincetraffics(String province, String traffics, String createtime) {
        this.province = province;
        this.traffics = traffics;
        this.createtime = createtime;
    }
    //辅助方法


    @Override
    public String toString() {
        return "Provincetraffics{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", traffics='" + traffics + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
