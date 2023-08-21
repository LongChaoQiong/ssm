package cn.gxnu.service;

import cn.gxnu.entity.Provincetraffics;

import java.util.List;

public interface Iprovincetraffics {
    //增加
    public void Add(Provincetraffics id);
    //删除
    public void DeletebyId(int id);
    //修改
   public void Updata(Provincetraffics provincetraffics);
    //某个时间
    public List<Provincetraffics> FindB(String createtime);
    //查询某时间段
    public List<Provincetraffics> FindA(String a,String b);

}
