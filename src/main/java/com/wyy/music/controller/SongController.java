package com.wyy.music.controller;

import com.wyy.music.common.Result;
import com.wyy.music.common.ResultCodeEnum;
import com.wyy.music.mapper.SongCollectRecentlyMapper;
import com.wyy.music.service.SongCollectRecentlyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author hongxiaobin
 * @Time 2023/6/5 0005-22:03:09
 */
@RestController
@RequestMapping("/song")
@Slf4j
public class SongController {
    @Resource
    private SongCollectRecentlyMapper songCollectRecentlyMapper;
    @Resource
    private SongCollectRecentlyService songCollectRecentlyService;

    /**
     * 保存最近播放歌曲、收藏歌曲
     *
     * @param uid     用户id
     * @param musicId 音乐id
     * @param type    0-最近播放，1-收藏
     * @return 请求结果
     */
    @GetMapping("/save")
    public Result<String> saveRecentlySong(@RequestParam String uid,
                                           @RequestParam String musicId,
                                           @RequestParam(defaultValue = "0") Integer type) {
        if (StringUtils.isAnyBlank(uid, musicId)) {
            return Result.build(null, ResultCodeEnum.DATA_ERROR);
        }
        return songCollectRecentlyService.saveSongRecently(uid, musicId, type);
    }

    /**
     * 获取最近播放的歌曲
     *
     * @param uid   用户ID
     * @param limit 返回的数目，默认为10
     * @return 音乐ID集合
     */
    @GetMapping("/recently/play")
    public Result<List<String>> getRecentlySong(@RequestParam String uid,
                                                @RequestParam(defaultValue = "10", required = false) Integer limit) {
        if (StringUtils.isAnyBlank(uid)) {
            return Result.build(null, ResultCodeEnum.DATA_ERROR);
        }
        return songCollectRecentlyService.getRecentlySong(uid, limit);
    }

    /**
     * 取消收藏
     * @param uid 用户id
     * @param musicId 音乐id
     * @return 请求结果
     */
    @GetMapping("/delete/collect")
    public Result<String> deleteCollectSong(@RequestParam String uid,
                                            @RequestParam String musicId) {
        if (StringUtils.isAnyBlank(uid,musicId)) {
            return Result.build(null, ResultCodeEnum.DATA_ERROR);
        }
        return songCollectRecentlyService.deleteCollectSong(uid,musicId);
    }

}
