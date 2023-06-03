package com.wyy.music.common;

/**
 * @Author hongxiaobin
 * @Time 2023/6/3 0003-10:31:21
 */
public class BaseResponse<T> {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -6759395627914971767L;
    /**
     * 业务层面状态码
     * 0 - 正常
     * 1 - 异常
     */
    private int code;
    /**
     * 业务逻辑信息
     */
    private String message;
    /**
     * 返回体数据
     */
    private T data;
    /**
     * 业务信息描述
     */
    private String description;

    public BaseResponse(int code, String message, T data, String description) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this(code, message, data, "");
    }

    public BaseResponse(int code, String message, String description) {
        this(code, message, null, description);
    }


    public BaseResponse(int code, T data) {
        this(code, "", data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage(), null, errorCode.getDescription());
    }

    public BaseResponse(ErrorCode errorCode, String message) {
        this(errorCode.getCode(), message, null, errorCode.getDescription());
    }

    public BaseResponse(ErrorCode errorCode, String message, String description) {
        this(errorCode.getCode(), message, null, description);
    }
}
