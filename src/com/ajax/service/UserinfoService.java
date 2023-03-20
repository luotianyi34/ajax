package com.ajax.service;

import com.ajax.bean.Userinfo;
import com.ajax.dao.UserinfoDao;

import java.util.List;

/**
 * @Author PangJunjie
 * @Date 2023/3/15/015
 */
public class UserinfoService {
    private UserinfoDao userinfoDao = new UserinfoDao();
    public Userinfo login(String username,String password){
        return userinfoDao.login(username, password);
    }

    public List<Userinfo> getPage(int page,int limit,Userinfo userinfo){
        return userinfoDao.getPage(page, limit, userinfo);
    }
}
