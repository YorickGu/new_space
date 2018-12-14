package com.pfuser.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Cookie
 * @description: 创建cookie的获取的servlet
 * @author: Yorick
 * @create: 2018-12-03 18:50
 */
@WebServlet(name = "GetCookieServlet",urlPatterns = "/gc")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置响应编码格式
        req.setCharacterEncoding("utf-8");
        //设置请求编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
            //获取cookie信息
        Cookie[] cks = req.getCookies();
        if (cks!=null) {
            for (Cookie c : cks) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + ":" + value);
            }
        }
            //获取用户信息
        //处理请求信息
        //响应请求结果
            //直接响应
            //请求转发
            //重定向
    }
}
