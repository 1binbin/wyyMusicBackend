package com.wyy.music.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hongxiaobin
 * @Time 2023/6/8 0008-10:14:53
 */
@Data
public class FileUpload implements Serializable {
    private static final long serialVersionUID = -3747650419376855810L;

    private String uid;
    private String avatarUrl;
}
