package cn.gxnu.controller;

import cn.gxnu.entity.Pnametraffics;
import cn.gxnu.service.imp.PnametrafficsService;
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

@WebServlet("/pnametraffics")    //取资源名要和前端对应
public class PnametrafficsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String b=req.getParameter("b");
        String e=req.getParameter("");

        System.out.println(b);
        System.out.println(e);
       //生成service对象
        PnametrafficsService pnametrafficsService=new PnametrafficsService();
        //创建一个集合
        List<Pnametraffics> listStraffics = new ArrayList<Pnametraffics>();

        if(e!=null && !equals("")&&!equals("null")){
            listStraffics =pnametrafficsService.FindA(b,e);//查询某个时间段
        }else
        {
            listStraffics =pnametrafficsService.FindB(b);//查询某天
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
