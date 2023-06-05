package com.wyy.music.service;

import com.wyy.music.common.Result;
import com.wyy.music.model.domain.SongCollectRecently;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hongxiaobin
* @description 针对表【song_collect_recently】的数据库操作Service
* @createDate 2023-06-05 22:07:30
*/
public interface SongCollectRecentlyService extends IService<SongCollectRecently> {

    /**
     * 保存最近播放的歌曲
     * @param uid 用户id
     * @param musicId 音乐id
     * @return 请求结果
     */
    Result<String> saveSongRecently(String uid, String musicId);

    /**
     * 获取最近播放的歌曲
     * @param uid 用户ID
     * @param limit 数目
     * @return 音乐ID集合
     */
    Result<List<String>> getRecentlySong(String uid, Integer limit);
}
