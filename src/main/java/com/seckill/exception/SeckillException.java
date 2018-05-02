package com.seckill.exception;

import org.jetbrains.annotations.NonNls;

/**
 * Created by dev on 2018/5/2.
 */
public class SeckillException extends  RuntimeException {
    public SeckillException(@NonNls String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
