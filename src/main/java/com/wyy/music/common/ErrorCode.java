package com.wyy.music.common;

/**
 * @Author hongxiaobin
 * @Time 2023/6/3 0003-10:31:52
 */
public enum ErrorCode {
    /**
     * 请求参数为空
     */
    PARAMS_ERROR(40000, "请求参数错误", "");


    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误信息
     */
    private final String message;
    /**
     * 信息描述
     */
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
