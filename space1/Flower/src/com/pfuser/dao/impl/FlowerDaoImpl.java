package com.pfuser.dao.impl;

import com.pfuser.dao.FlowerDao;
import com.pfuser.pojo.Flower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Flower
 * @description: 具体实现
 * @author: Yorick
 * @create: 2018-12-19 10:26
 **/
public class FlowerDaoImpl implements FlowerDao {

    @Override
    public List<Flower> selAll() {
        //从jdk1.7开始，后面的泛型可以省略
        List<Flower> list = new ArrayList<Flower>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            String sql = "select * from flower";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Flower(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int insFlower(Flower flower) {
        Connection conn = null;
        PreparedStatement ps = null;
        int index=-1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            String sql = "insert into flower values (default ,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,flower.getName());
            ps.setDouble(2,flower.getPrice());
            ps.setString(3,flower.getProduction());
            index = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }
}
