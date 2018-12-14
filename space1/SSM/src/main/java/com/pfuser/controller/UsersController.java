package com.pfuser.controller;

import com.pfuser.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @program: SSM
 *
 * @description: 控制文件
 *
 * @author: Yorick
 *
 * @create: 2018-12-13 14:15
 **/

@Controller
public class UsersController {
    @Resource
    private UsersService usersserviceimpl;
    @RequestMapping("show")
    public String show(Model model){
        model.addAttribute("list",usersserviceimpl);
        return "index.jsp";

    }
}
