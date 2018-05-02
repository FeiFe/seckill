package com.seckill.dao;


import com.seckill.model.Seckill;
import com.seckill.dao.SeckillDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dev on 2018/5/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    @Resource()
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() throws Exception {
        Date killDate = new Date();
        int reduceNumber = seckillDao.reduceNumber(1000L, killDate);
        System.out.println(reduceNumber);

    }

    @Test
    public void queryById() throws Exception {
        long id=1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
    }

    @Test
    public void queryAll() throws Exception {
       List<Seckill> list= seckillDao.queryAll(0, 100);
        for (Seckill seckill : list) {
            System.out.println(seckill.getName());
        }
    }

}