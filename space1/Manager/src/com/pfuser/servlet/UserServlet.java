package com.pfuser.servlet;

import com.pfuser.pojo.User;
import com.pfuser.service.UserService;
import com.pfuser.service.impl.UserSeviceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * servlet重定向路径总结
 *  相当路径:从当前请求的路径查找资源的路径
 *      相对路径如果servlet的别名中包含目录,会造成重定向资源查找失败
 *  绝对路径：第一个/表示服务器根目录
 *      /虚拟项目名/资源路径
 *
 *  servlet 请求转发：
 *    /表示项目根目录
 *    req.getRequestDispather("/资源路径").forward(req,resp);
 *
 *
 */

/**
 * @program: Manager
 * @description: 这是servlet层，主要工作就是在对网页端的请求信息进行处理，并响应处理结果
 * @author: Yorick
 * @create: 2018-12-06 14:59
 */
@WebServlet(name = "UserServlet", urlPatterns = "/login")
public class UserServlet extends HttpServlet {
    Logger logger = Logger.getLogger(UserServlet.class);
    UserService us = new UserSeviceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取操做符
        String oper = req.getParameter("oper");
        if ("login".equals(oper)) {
            //调用登录处理方法
            checkUserLogin(req, resp);
        } else if ("out".equals(oper)) {
            //调用退出功能
            userOut(req, resp);
        } else if ("pwd".equals(oper)) {
            //调用密码修改功能
            System.out.println("111");
            userChangePwd(req, resp);

        } else if ("show".equals(oper)) {
            //调用显示所有用户功能
            userShow(req, resp);
        } else if ("reg".equals(oper)) {
            //调用注册功能
            userReg(req, resp);
        } else {
            System.out.println("没有找到对应的操作符");
            logger.debug("没有找到对应的操作符："+oper);
        }
    }

    //处理登录
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname+":"+pwd);
        //处理请求信息
        //校验
        User u = us.checkUserLoginService(uname, pwd);
        System.out.println(u);
        if (u != null) {
            //获取session对象
            HttpSession hs = req.getSession();
            //将用户数据存储到session中
            hs.setAttribute("user", u);
            //重定向
            resp.sendRedirect("/mg/main/main.jsp");
            return;
        } else {
            //添加标识符到request中
            req.setAttribute("flag", 0);
            //请求转发
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        //响应处理结果
        //直接响应
        //请求转发
    }

    //注册用户
    private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        int age = req.getParameter("age") != "" ? Integer.parseInt(req.getParameter("age")) : 0;
        String birth = req.getParameter("birth");
        String[] bs = null;
        if (birth != "") {
            bs = birth.split("/");
            birth = bs[2] + "-" + bs[0] + "-" + bs[1];
        }
        System.out.println(uname + ":" + pwd + ":" + sex + ":" + age + ":" + birth);
        User u = new User(0, uname, pwd, sex, age, birth);
        //处理请求信息
        //调用业务层处理
        int index = us.RegService(u);
        //响应处理结果
        if (index > 0) {
            //获取session
            HttpSession hs = req.getSession();
            hs.setAttribute("reg", "true");
            //重定向
            resp.sendRedirect("/mg/login.jsp");
        }

    }

    //显示所有的用户信息
    private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求
        //调用service
        List<User> lu = us.UserShowSerive();
        //判断
        if (lu != null) {
            //将查询的用户数据存储到request对象
            req.setAttribute("lu", lu);
            //请求转发
            req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
            return;
        }

    }

    //用户修改密码
    private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取数据
        String newPwd = req.getParameter("newPwd");
        //从session中获取用户信息
        User u = (User) req.getSession().getAttribute("user");
        int uid = u.getUid();
        //处理请求
            //调用service处理
        int index = us.UserChangePwdService(newPwd, uid);
        System.out.println(index+"这是我在测试我刚装的插件的效果");
        if (index > 0) {
            //获取session对象
            HttpSession hs = req.getSession();
            hs.setAttribute("pwd", "true");
            //重定向到登录页面
            resp.sendRedirect("/mg/login.jsp");
        }
    }

    //用户退出
    private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取session对象
        HttpSession hs = req.getSession();
        //强制销毁session
        hs.invalidate();
        //重定向到登录页面
        resp.sendRedirect("/mg/login.jsp");
    }



}
