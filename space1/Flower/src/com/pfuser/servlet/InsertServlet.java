package com.pfuser.servlet;

import com.pfuser.pojo.Flower;
import com.pfuser.service.FlowerService;
import com.pfuser.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Flower
 * @description: 这是对数据的新增的jsp
 * @author: Yorick
 * @create: 2018-12-20 10:31
 */
@WebServlet(name = "InsertServlet",urlPatterns = "/ins")
public class InsertServlet extends HttpServlet {
    private FlowerService flowerService = new FlowerServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String production = req.getParameter("production");
        Flower flower = new Flower();
        flower.setName(name);
        flower.setPrice(Double.parseDouble(price));
        flower.setProduction(production);
        int index = flowerService.add(flower);
        if (index>0){
            //防止表单重复提交
            resp.sendRedirect("show");
//            req.getRequestDispatcher("show").forward(req,resp);
        }else{
            resp.sendRedirect("add.jsp");
//            req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
    }
}
