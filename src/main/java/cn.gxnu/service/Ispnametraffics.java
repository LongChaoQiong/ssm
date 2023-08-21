package cn.gxnu.service;

import cn.gxnu.entity.SPnametraffics;

import java.util.List;

public interface Ispnametraffics {
    //增加
    public void Add(SPnametraffics spnametraffics);
    //删除
    public void DeletebyId(int id);
    //修改
    public void Updata(SPnametraffics spnametraffics);


    public List<SPnametraffics> FindB(String createtime);

    public List<SPnametraffics> FindA(String b, String e);
}
