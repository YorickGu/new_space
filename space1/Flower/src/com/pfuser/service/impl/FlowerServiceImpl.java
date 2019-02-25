package com.pfuser.service.impl;


import com.pfuser.dao.FlowerDao;
import com.pfuser.dao.impl.FlowerDaoImpl;
import com.pfuser.pojo.Flower;
import com.pfuser.service.FlowerService;

import java.util.List;

/**
 * @program: Flower
 *
 * @description: service的实现
 *
 * @author: Yorick
 *
 * @create: 2018-12-19 11:23
 **/
public class FlowerServiceImpl implements FlowerService {
    private FlowerDao flowerDao = new FlowerDaoImpl();

    @Override
    public List<Flower> show() {
        return flowerDao.selAll();
    }

    @Override
    public int add(Flower flower) {
        return flowerDao.insFlower(flower);
    }

}
