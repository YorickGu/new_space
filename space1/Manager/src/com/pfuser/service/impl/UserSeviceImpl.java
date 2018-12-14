package com.pfuser.service.impl;/**
 * @program: Manager
 * @description: 对用户的数据集成操作的实现
 * @author: Yorick
 * @create: 2018-12-06 14:58
 */

import com.pfuser.dao.UserDao;
import com.pfuser.dao.impl.UserDaoImpl;
import com.pfuser.pojo.User;
import com.pfuser.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @program: Manager
 *
 * @description: 对用户的数据集成操作的实现
 *
 * @author: Yorick
 *
 * @create: 2018-12-06 14:58
 **/
public class UserSeviceImpl implements UserService {
    /**
     * Description: 声明日志对象
     * @param:
     * @return:
     */
    Logger loggger = Logger.getLogger(UserSeviceImpl.class);
    UserDao ud = new UserDaoImpl();

    /**
     * Description: 根据用户名和密码检查用户的注册信息
     * @param: [uname, pwd]
     * @return: com.pfuser.pojo.User
     */
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        //打印日志
        loggger.debug(uname+"发起登录请求");
        User u = ud.checkUserLoginDao(uname,pwd);
        if (u!=null){
            loggger.debug(uname+"登录成功");
            System.out.println("登录成功");
        }else {
            loggger.debug(uname+"登录失败");
            System.out.println("登录失败");
        }
        return u;
    }

    /**
     * Description: 根据uid来修改用户的密码
     * @param: [newPwd, uid]
     * @return: int
     */
    @Override
    public int UserChangePwdService(String newPwd, int uid) {
        loggger.debug("可以的"+uid+"发起密码修改请求");
        int index = -1;
        index = ud.UserChangePwdDao(newPwd,uid);
        System.out.println(index);
        if (index!=-1){
            loggger.debug(uid+"密码修改成功");
            System.out.println("修改成功");
        }else {
            loggger.debug(uid+"密码修改失败");
            System.out.println("修改失败");
        }
        return index;
    }

    /**
     * Description:展示所有用户的所有信息
     * @param: []
     * @return: java.util.List<com.pfuser.pojo.User>
     */
    @Override
    public List<User> UserShowSerive() {
        List<User> lu = ud.UserShow();
        loggger.debug("显示所有用户信息："+lu);
        return lu;
    }

    /**
     * Description: 用户注册
     * @param: [u]
     * @return: int
     */
    @Override
    public int RegService(User u) {

        return ud.RegDao(u);
    }
}
