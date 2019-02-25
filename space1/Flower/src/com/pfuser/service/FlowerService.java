package com.pfuser.service;

import com.pfuser.pojo.Flower;

import java.util.List;

/**
 * @program: Flower
 * @description: ${description}
 * @author: Yorick
 * @create: 2018-12-19 11:22
 */
public interface FlowerService {
    List<Flower> show();
    int add(Flower flower);
}
