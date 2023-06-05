package com.wyy.music.exception;

import com.wyy.music.common.ResultCodeEnum;

/**
 * 全局异常类
 *
 * @Author hongxiaobin
 * @Time 2023/2/28-16:33
 */
public class BusinessException extends RuntimeException {

    private final int code;

    /**
     * 全参构造函数
     *
     * @param errorCode 错误枚举类
     */
    public BusinessException(ResultCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }

}
