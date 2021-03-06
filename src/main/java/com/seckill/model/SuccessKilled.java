package com.seckill.model;

import java.util.Date;

public class SuccessKilled extends SuccessKilledKey {
    private Byte state;

    private Date createTime;

    private Seckill seckill;

    public SuccessKilled(Long seckillId, Long userPhone, Byte state, Date createTime) {
        super(seckillId, userPhone);
        this.state = state;
        this.createTime = createTime;
    }

    public SuccessKilled() {
        super();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "state=" + state +
                ", createTime=" + createTime +
                ", seckill=" + seckill +
                '}';
    }
}