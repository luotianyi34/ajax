package com.ajax.servlet;

import com.ajax.bean.Userinfo;
import com.ajax.service.UserinfoService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author PangJunjie
 * @Date 2023/3/15/015
 */
@WebServlet("/userinfo")
public class UserinfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        int page = 1;
        int limit = 5;

        UserinfoService userinfoService = new UserinfoService();
        List<Userinfo> userList = userinfoService.getPage(page,limit,new Userinfo());
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","success");
        map.put("data",userList);
        response.getWriter().println(JSON.toJSON(map));
    }
}
