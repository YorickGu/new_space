package com.pfuser.service.impl;

import com.pfuser.Pojo.Flower;
import com.pfuser.service.Flowerservice;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 在数据访问层异常处理和控制器中处理异常，service只是抛出异常
 */
public class FlowerServiceImpl implements Flowerservice {
    @Override
    public List<Flower> show() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //前面是工厂    实例化工厂对象时用的是构建者设计模式  构建者设计模式的标志是后面有个Builder
        //构建者设计模式存在的意义是简化对象实例化过程
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        List<Flower> list = session.selectList("gyj.user.findAll");
        session.close();
        return list;
    }

    @Override
    public void update() throws IOException {

        int index= 0;
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        Flower flower = session.selectOne("gyj.user.get",2);


        flower.setName("喇叭花");
        flower.setPrice(13);

        session.update("gyj.user.update",flower);

        session.commit();
        session.close();

    }


}
