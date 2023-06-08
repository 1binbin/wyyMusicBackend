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
    PHONE_ERROR(502, "手机号错误"),
    PASSWORD_ERROR(400, "密码错误"),
    OBJECT_ERROR(401, "对象为空"),
    DATA_ERROR(401, "参数为空"),
    PARAM_ERROR(401, "参数错误"),
    ACCOUNT_DUPLICATION(401, "账号重复或不存在"),
    FILE_UPLOAD_ERROR(401, "文件上传失败"),
    FAIL(402, "操作失败");

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
