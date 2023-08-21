package cn.gxnu.controller;

import cn.gxnu.entity.Provincetraffics;
import cn.gxnu.service.imp.ProvincetrafficsService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/provincetraffics")
public class ProvincetrafficsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String b=req.getParameter("b");
        String e=req.getParameter("e");

        ProvincetrafficsService provincetrafficsService=new ProvincetrafficsService();
        List<Provincetraffics> listStraffics = new ArrayList<Provincetraffics>();
        if(e!=null && !equals("")&&!equals("null")){
            listStraffics =provincetrafficsService.FindA(b,e);//查询某个时间段
        }else
        {
            listStraffics =provincetrafficsService.FindB(b);//查询某天
        }
        //业务层获得的集合，用MAp包装，还有前端要求的code为20000;集合的Key必须为data
        //把数据放在Map中，方便转换成json格式
        Map<Object,Object> msg=new HashMap<>();
        msg.put("code",20000);
        msg.put("data",listStraffics);

        //将data转换成json
        Gson gson = new Gson();
        String jsondata = gson.toJson(msg);//将集合转换成json格式
        System.out.println(jsondata);

        //设置响应对象内容的类型和及编码方式 json数据
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(jsondata);
    }
}
