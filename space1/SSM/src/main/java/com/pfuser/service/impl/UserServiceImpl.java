package com.pfuser.service.impl;

import com.pfuser.mapper.UsersMapper;
import com.pfuser.pojo.Users;
import com.pfuser.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: SSM
 *
 * @description: 实现方法
 *
 * @author: Yorick
 *
 * @create: 2018-12-13 14:13
 **/
@Service
public class UserServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<Users> show() {
        return usersMapper.selAll();
    }
}
