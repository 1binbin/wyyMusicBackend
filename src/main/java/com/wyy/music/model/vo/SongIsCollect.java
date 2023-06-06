package com.wyy.music.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hongxiaobin
 * @Time 2023/6/5 0005-20:43:35
 */
@Data
public class SongIsCollect implements Serializable {
    private static final long serialVersionUID = -3747650419376855810L;

    private String uid;
    private String musicId;
    private Boolean isCollect;
}