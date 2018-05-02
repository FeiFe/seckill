package com.seckill.exception;

import org.jetbrains.annotations.NonNls;

/**重复秒杀异常
 * Created by dev on 2018/5/2.
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(@NonNls String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
