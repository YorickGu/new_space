package com.pfuser.dao;

import com.pfuser.pojo.User;

import java.util.List;

/**
 * @program: Manager
 * @description: 存放对用户信息数据库的基本操作
 * @author: Yorick
 * @create: 2018-12-06 14:34
 */
public interface UserDao {
    /**
     * Description: 
     * @param: [uname, pwd]
     * @return: com.pfuser.pojo.User
     */
    User checkUserLoginDao(String uname,String pwd);
    /**
     * Description: 根据用户的id来修改密码
     * @param: [newPwd, uid]
     * @return: int
     */
    int UserChangePwdDao(String newPwd,int uid);
    /**
     * Description: 展现用户所有信息
     * @param: []
     * @return: java.util.List<com.pfuser.pojo.User>
     */
    List<User> UserShow();
    /**
     * Description: 用户注册
     * @param: [u]
     * @return: int
     */
    int RegDao(User u);
    
    

}
