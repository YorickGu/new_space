package com.pfuser.servlet;

import com.pfuser.Pojo.Flower;
import com.pfuser.service.Flowerservice;
import com.pfuser.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns ="/ss")
public class ShowServlet extends javax.servlet.http.HttpServlet {

    private Flowerservice flowerservice = new FlowerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        flowerservice.update();

        List<Flower> list = flowerservice.show();
        //将查询到的list里的数据放置到一个变量list中去
        req.setAttribute("list",list);

        //请求转发，
        //主要路径是以/开头的都是全路径，不以/开头的都是相对路径，都是从当前资源出发来找其他资源
        //相对路径
        //如果请求转发， /表示的web目录
        //如果是重定向，静态资源引用，必须是<img src="" /> <a href= ""> <script src="" />
        //其中的/都表示tomcat的webappa文件夹根目录
        //服务器根目录

        req.getRequestDispatcher("index.jsp").forward(req,resp);


    }
}
