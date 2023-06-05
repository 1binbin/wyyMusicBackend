package com.wyy.music.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hongxiaobin
 * @Time 2023/6/5 0005-20:43:35
 */
@Data
public class UserUpdate implements Serializable {
    private static final long serialVersionUID = -3747650419376855810L;

    private Integer gender;
    private String nickname;
    private String avatarUrl;
    private String birthday;
    private String phone;
    private String password;
}
