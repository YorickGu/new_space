package com.pfuser.dao;

import com.pfuser.pojo.Flower;

import java.util.List;

/**
 * @program: Flower
 *
 * @description: 花卉信息数据操作
 *
 * @author: Yorick
 *
 * @create: 2018-12-19 10:13
 **/
public interface FlowerDao {

    /**
     * Description:  查询全部
     * @param: []
     * @return: java.util.List<com.pfuser.pojo.Flower>
     */
    List<Flower> selAll();

    /**
     * Description: 新增花卉信息
     * @param: [flower]
     * @return: int
     */
    int insFlower(Flower flower);
}
