package com.pfuser.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CookieServlet extends HttpServlet {
    /**
     * Description: 对于service方法的重写
     *
     * @param: [req, resp]
     * @return: void
     * @auther: Yorick
     * @date: 2018/12/3 15:21
     * <p>
     * 对于cookie的学习：
     * 作用：解决了发送的不同数据共享问题
     * 使用：
     *  cookie的创建和存储
     *
     *  创建cookie对象
     *      cookie c = new cookie(string name,string value);
     *      设置cookie的有效期
     *      c2.setMaxAge(3*24*60*60);
     *      设置cookie有效路径
     *      c2.setPath("/cookie/abc");
     *      响应cookie信息给客户端
     *      resp.addcookie(c)
     *
     *      cookie的获取
     *      //获取cookie信息数组
     *      cookie[] cks = req.getcookies();
     *      //遍历数组获取cookie信息
     *      使用for循环遍历即可，示例
     *         if (cks!=null) {
     *             for (Cookie c : cks) {
     *                 String name = c.getName();
     *                 String value = c.getValue();
     *                 System.out.println(name + ":" + value);
     *             }
     *         }
     *
     *  注意：
     *     一个cookie对象只存储一条数据，多条数据可以创建多个cookie对象进行存储。
     *   特点：浏览器端的数据存储技术
     *          存储的数据声明在服务器端。
     *          临时存储：存储在浏览器的运行内存中，浏览器关闭即失效
     *          定时存储：设置了cookie的有效期内，存储在客户端的硬盘中，在有效期内符合要求的请求都会附带该信息
     *    默认是cookie信息存储好以后，每次都会附带，除非设置有效路径。
     *
     *
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        //处理请求信息
        //响应处理结果
        //使用cookie进行浏览器端的数据存储
        //创建cookie对象
        Cookie c = new Cookie("mouse","thinkpad");
        Cookie c2 = new Cookie("pfuser","baby");
        //设置cookie有效期
        c2.setMaxAge(3*24*60*60);
        //设置有效路径
        c2.setPath("/cookie/gc");
        //响应cookie
        resp.addCookie(c);
        resp.addCookie(c2);
        //直接响应
        resp.getWriter().write("Cookie！！！！");
        //请求转发
        //重定向
    }
}
