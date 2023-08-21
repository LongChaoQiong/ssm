package cn.gxnu.service;

import cn.gxnu.entity.Pnametraffics;

import java.util.List;

public interface Ipnametraffics {
    //增加
    public void Add(Pnametraffics pnametraffics);
    //删除
    public void DeletebyId(int id);
    //修改
    public void Updata(Pnametraffics pnametraffics);
    //单查询
    public List<Pnametraffics> FindB(String createtime);
    //查询所有
    public List<Pnametraffics> FindA(String a,String b);

}
