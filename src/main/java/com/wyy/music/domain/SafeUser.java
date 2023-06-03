package com.wyy.music.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 性别 0-女 1-男
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 头像地址
     */
    @TableField(value = "avatarUrl")
    private String avatarUrl;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 是否删除
     */
    @TableField(value = "isDelete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
