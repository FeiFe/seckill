package com.seckill.dao;

import com.seckill.model.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by dev on 2018/5/1.
 */
public interface SuccessKillDao {
    /**
     * 插入购买明细 可过滤重复
     * @param seckill
     * @param userPhon
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") Long seckillId, @Param("userPhone")long userPhone);

    /**
     * 主键查询 并携带秒杀产品对象
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") Long seckillId, @Param("userPhone")long userPhone);
}
