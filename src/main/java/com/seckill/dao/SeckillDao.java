package com.seckill.dao;

import com.seckill.model.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by dev on 2018/5/1.
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killtime
     * @return
     */
    int reduceNumber(@Param("seckillId")Long seckillId,@Param("kill_time")Date killtime);

    /**
     * 根据主键查询
     * @param seckillId
     * @return
     */
    Seckill queryById(Long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offet") int offet, @Param("limit")int limit);
}
