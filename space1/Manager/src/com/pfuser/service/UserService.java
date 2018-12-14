package com.pfuser.service;

import com.pfuser.pojo.User;

import java.util.List;

/**
 * @program: Manager
 * @description: 对用户的信息数据库的集成操作
 * @author: Yorick
 * @create: 2018-12-06 14:57
 */
public interface UserService {
    /**
     * Description: 根据用户名和密码来检查用户
     * @param: [uname, pwd]
     * @return: com.pfuser.pojo.User
     */
    User checkUserLoginService(String uname,String pwd);
    /**
     * Description: 根据uid来修改用户的密码信息
     * @param: [newPwd, uid]
     * @return: int
     */
    int UserChangePwdService(String newPwd,int uid);
    /**
     * Description: 显示所有用户的所有信息
     * @param: []
     * @return: java.util.List<com.pfuser.pojo.User>
     */
    List<User> UserShowSerive();
    /**
     * Description: 用户注册
     * @param: [u]
     * @return: int
     */
    int RegService(User u);
}
