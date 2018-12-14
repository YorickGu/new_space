package com.pfuser.dao.impl;
/**
 * @program: Manager
 * @description: 对用户数据库信息操作的实现
 * @author: Yorick
 * @create: 2018-12-06 14:48
 */

import com.pfuser.dao.UserDao;
import com.pfuser.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Manager
 * @description: 对用户数据库信息操作的实现
 * @author: Yorick
 * @create: 2018-12-06 14:48
 **/
public class UserDaoImpl implements UserDao {

    /**
     * Description: 根据用户的名字和密码来检查用户是否已经在网站名单中
     *
     * @param: [uname, pwd]
     * @return: com.pfuser.pojo.User
     */
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8", "root", "123456");
            String sql = "select * from t_user where uname =? and pwd =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
            }
        } catch (Exception e) {
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
        return u;
    }

    /**
     * Description: 根据uid来更新用户的新密码
     *
     * @param: [newPwd, uid]
     * @return: int
     */
    @Override
    public int UserChangePwdDao(String newPwd, int uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8", "root", "123456");
            String sql = "update t_user set pwd = ? where uid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPwd);
            ps.setInt(2, uid);
            index = ps.executeUpdate();
            System.out.println(index);
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
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
//        System.out.println(index);
        return index;
    }

    /**
     * Description: 展示所有用户的所有信息
     *
     * @param: []
     * @return: java.util.List<com.pfuser.pojo.User>
     */
    @Override
    public List<User> UserShow() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> lu = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8", "root", "123456");
            String sql = "select * from t_user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            lu = new ArrayList<User>();
            while (rs.next()) {
                User u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
                //将对象存储到集合中
                lu.add(u);
            }
        } catch (Exception e) {
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
        System.out.println(lu);
        return lu;
    }

    @Override
    public int RegDao(User u) {
        Connection conn = null;
        PreparedStatement ps = null;
        int index = -1;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8", "root", "123456");
            String sql = "insert into t_user values(default,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1,u.getUname());
            ps.setString(2, u.getPwd());
            ps.setString(3, u.getSex());
            ps.setInt(4, u.getAge());
            ps.setString(5, u.getBirth());

            index = ps.executeUpdate();
        } catch (Exception e) {
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
