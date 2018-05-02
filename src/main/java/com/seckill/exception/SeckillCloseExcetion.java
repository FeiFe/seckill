package com.seckill.exception;

import org.jetbrains.annotations.NonNls;

/**
 * Created by dev on 2018/5/2.
 */
public class SeckillCloseExcetion extends SeckillException {
    public SeckillCloseExcetion(@NonNls String message) {
        super(message);
    }

    public SeckillCloseExcetion(String message, Throwable cause) {
        super(message, cause);
    }
}
