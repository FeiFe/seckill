package com.seckill.service;

import com.seckill.dto.Export;
import com.seckill.dto.SeckillExecution;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseExcetion;
import com.seckill.model.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dev on 2018/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;
    @Test
    public void querySeckillList() throws Exception {
        List<Seckill> seckills = seckillService.querySeckillList();
        logger.info("list={}",seckills);
    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill = seckillService.queryById(1000L);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        Export export = seckillService.exportSeckillUrl(1001L);
        if (export.isExposed()){
            logger.info("export={}",export);
            try {
                SeckillExecution execution = seckillService.executeSeckill(1001L, 18396069874L, "b2a69ba54f4b5e14529b79a5a334e9a3");
                logger.info("execution={}",execution);
            }catch (RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillCloseExcetion e){
                logger.error(e.getMessage());
            }

        }else{
            logger.warn("export={}",export);
        }
    }


}