package com.wyy.music.common;

import lombok.Getter;

/**
 * 响应结果类型枚举
 *
 * @Author hongxiaobin
 * @Time 2022/10/11-15:39
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    PHONE_ERROR(502,"手机号错误"),
    PASSWORD_ERROR(400,"密码错误"),
    DATA_ERROR(401,"参数为空"),
    FAIL(402,"操作失败");

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
