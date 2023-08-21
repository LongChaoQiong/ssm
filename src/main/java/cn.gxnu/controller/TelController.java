package cn.gxnu.controller;


import cn.gxnu.util.JsonURL_formater;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//连接大数据部分
// url: '/api/tel?b=' + b + '&e=' + e + '&tn=' + tn,
//         method: 'get'

@WebServlet("/tel")
public class TelController extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(TelController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String b = req.getParameter("b");
        String e = req.getParameter("e");
        String tn = req.getParameter("tn");//手机号
        // String jsonText = "";
        List<Object> temp = new ArrayList<Object>();
        try {
            //http://36.110.54.251:8098/loadhbase?keys=20200318-13001293555,20200318-13001291786  //写算法去转换格式
            String url = "http://36.110.54.251:8098/loadhbase?keys="; //Hbase 的数据库地址，当前这个这个是用不了
            // String url = "http://linux1:8761/loadhbase?keys=";
            if(e!=null && !e.equals("") && !e.equals("null")){
                url += JsonURL_formater.format(b,e,tn);
            }else{
                url += b;
                url += "-";
                url += tn;
            }
            logger.info(url);
            // 创建jackson对象
            ObjectMapper om = new ObjectMapper();
            temp = om.readValue(new URL(url), new TypeReference<List<Object>>() {});
        } catch (MalformedURLException ex) {
            System.out.print("数据加载失败");
            logger.info("数据加载失败"+ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.print("数据传输失败");
            logger.info("数据传输失败"+ex.getMessage());
            ex.printStackTrace();
        }
        Map<String,Object> msg = new HashMap<>();
        msg.put("code",20000);
        msg.put("data",temp);
    }
}
