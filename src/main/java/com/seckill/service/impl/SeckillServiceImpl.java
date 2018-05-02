package com.seckill.service.impl;

import com.seckill.dao.SeckillDao;
import com.seckill.dao.SuccessKillDao;
import com.seckill.dto.Export;
import com.seckill.dto.SeckillExecution;
import com.seckill.enums.SeckillStatusEnum;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseExcetion;
import com.seckill.exception.SeckillException;
import com.seckill.model.Seckill;
import com.seckill.model.SuccessKilled;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by dev on 2018/5/2.
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKillDao successKillDao;

    private final  String salt="adqwQWEWQE231213./.;'l,.ssdfw32#@$";
    public List<Seckill> querySeckillList() {
        return seckillDao.queryAll(0,4);
    }

    public Seckill queryById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Export exportSeckillUrl(long seckillId) {
        Seckill seckill= queryById(seckillId);
        if (null==seckill){
            return new Export(false,seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date now=new Date();
        if(now.getTime()<startTime.getTime()||now.getTime()>endTime.getTime()){
            return new Export(false,seckillId,now.getTime(),startTime.getTime(),endTime.getTime());
        }
        String md5= getMD5(seckillId);
        return new Export(true,md5,seckillId);
    }
    private String getMD5(long seckillId){
        String base=seckillId+"/"+salt;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillCloseExcetion, RepeatKillException, SeckillException {
        try {
            if (md5==null|| !md5.equals(getMD5(seckillId))){
                throw  new SeckillException("sesckill data rewrite");
            }
            int reduceNumber = seckillDao.reduceNumber(seckillId, new Date());
            if(reduceNumber<=0){
                throw  new SeckillCloseExcetion("seckill is closed");
            }else{
                int successKilled = successKillDao.insertSuccessKilled(seckillId, userPhone);
                if(successKilled<=0){
                    throw  new RepeatKillException("seckill  repeated");
                }else{
                    SuccessKilled successKill = successKillDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatusEnum.SUCCESSS,successKill);
                }
            }
        }catch (SeckillCloseExcetion e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        }catch (Exception e){
            logger.info(e.getMessage(),e);
            throw new SeckillException("seckill inner error :"+ e.getMessage());
        }

    }
}
