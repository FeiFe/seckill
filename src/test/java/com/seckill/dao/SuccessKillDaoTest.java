package com.seckill.dao;

import com.seckill.model.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dev on 2018/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKillDaoTest {
    @Resource
    private SuccessKillDao successKillDao;
    @Test
    public void insertSuccessSeckilld() throws Exception {
        int insertSuccessSeckilld = successKillDao.insertSuccessKilled(1001L, 18396069873L);
        System.out.println("insertSuccessSeckilld="+insertSuccessSeckilld);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        SuccessKilled successKilled = successKillDao.queryByIdWithSeckill(1001L, 18396069873L);
        System.out.println(successKilled.getUserPhone());
        System.out.println(successKilled.getSeckill());
    }

}