package com.wyy.music.service;

import com.wyy.music.common.Result;
import com.wyy.music.model.domain.SongCollectRecently;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyy.music.model.vo.SongIsCollect;

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
     * @param type 0-最近播放，1-收藏
     * @return 请求结果
     */
    Result<String> saveSongRecently(String uid, String musicId,Integer type);

    /**
     * 获取最近播放的歌曲
     * @param uid 用户ID
     * @param limit 数目
     * @return 音乐ID集合
     */
    Result<List<String>> getRecentlySong(String uid, Integer limit);

    /**
     * 取消收藏
     * @param uid 用户ID
     * @param musicId 音乐ID
     * @return 请求结果
     */
    Result<String> deleteCollectSong(String uid, String musicId);

    /**
     * 判断歌曲是否收藏
     * @param uid 用户ID
     * @param musciId 音乐ID
     * @return 响应数据
     */
    Result<SongIsCollect> getIsCollect(String uid, String musciId);
}
