package com.wyy.music.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author hongxiaobin
 * @Time 2023/6/3 0003-11:24:44
 */
@Data
public class SafeUser implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 性别 0-女 1-男
     */
    private Integer gender;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 是否删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
