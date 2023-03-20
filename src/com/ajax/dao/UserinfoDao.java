package com.ajax.dao;

import com.ajax.bean.Userinfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author PangJunjie
 * @Date 2023/3/15/015
 */
public class UserinfoDao {
    private Connection connection=null;
    private PreparedStatement pstm = null;
    private ResultSet resultSet;

    public UserinfoDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xuhai20-1?useSSL=false&serverTimezone=UTC&charsetEncoding=utf-8","root","root");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序无法加载");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("数据库连接异常");
            throw new RuntimeException(e);
        }
    }


    public Userinfo login(String username,String password){
        String sql = "select * from userinfo where username = ? and password = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);
            resultSet = pstm.executeQuery();
            if(resultSet.next()){
                Userinfo userinfo = new Userinfo();
                userinfo.setId(resultSet.getInt("id"));
                userinfo.setUsername(resultSet.getString("username"));
                userinfo.setPassword(resultSet.getString("password"));
                userinfo.setNickname(resultSet.getString("nickname"));
                userinfo.setStatus(resultSet.getInt("status"));
                return userinfo;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public List<Userinfo> getPage(int page,int limit,Userinfo userinfo){
        String sql = "select * from userinfo where 1 = 1 ";
        List<Object> list = new ArrayList<>();
        if(userinfo.getUsername()!=null&&userinfo.getUsername().length()>0){
            sql += " and username = ? ";
            list.add(userinfo.getUsername());
        }
        if(userinfo.getNickname()!=null&&userinfo.getNickname().length()>0){
            sql+=" and nickname like ? ";
            list.add("%"+userinfo.getNickname()+"%");
        }
        if(userinfo.getStatus() != null){
            sql += " and status = ? ";
            list.add(userinfo.getStatus());
        }
        sql += "order by id desc limit ?,?";
        list.add((page-1)*limit);
        list.add(limit);
        List<Userinfo> userList = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            for(int i=0;i<list.size();i++){
                pstm.setObject(i+1,list.get(i));
            }
            resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Userinfo user = new Userinfo();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setStatus(resultSet.getInt("status"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
