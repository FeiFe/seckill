package com.seckill.dto;

import com.seckill.enums.SeckillStatusEnum;
import com.seckill.model.SuccessKilled;

/**
 * Created by dev on 2018/5/2.
 */
public class SeckillExecution {
    private long seckillId;
    private int status;
    private String statusInfo;
    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId,SeckillStatusEnum statusEnum) {
        this.seckillId = seckillId;
        this.status = statusEnum.getStatus();
        this.statusInfo = statusEnum.getStatusInfo();
    }

    public SeckillExecution(long seckillId, SeckillStatusEnum statusEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.status = statusEnum.getStatus();
        this.statusInfo = statusEnum.getStatusInfo();
        this.successKilled = successKilled;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", status=" + status +
                ", statusInfo='" + statusInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }
}
