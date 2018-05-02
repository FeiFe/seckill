package com.seckill.enums;

/**
 * Created by dev on 2018/5/2.
 */
public enum SeckillStatusEnum {
    SUCCESSS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int status;
    private  String statusInfo;

    SeckillStatusEnum(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
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
    public  static  SeckillStatusEnum statusOf(int index){
        for (SeckillStatusEnum status : values()){
            if (status.getStatus()==index){
                return  status;
            }
        }
        return null;
    }
}
