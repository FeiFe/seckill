package com.seckill.service;

import com.seckill.dto.Export;
import com.seckill.dto.SeckillExecution;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseExcetion;
import com.seckill.exception.SeckillException;
import com.seckill.model.Seckill;

import java.util.List;

/**
 * Created by dev on 2018/5/2.
 */
public interface SeckillService {
    /**
     * 查询所有秒杀
     * @return
     */
    List<Seckill> querySeckillList();

    /**
     * 主键查询
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 秒杀开启输出秒杀接口，否则输出系统时间
     * @param seckillId
     */
    Export exportSeckillUrl(long seckillId);

    SeckillExecution executeSeckill(long seckill, long userPhone, String md5)
            throws SeckillCloseExcetion,RepeatKillException,SeckillException;
}
