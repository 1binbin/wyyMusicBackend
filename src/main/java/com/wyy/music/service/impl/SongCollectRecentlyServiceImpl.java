package com.wyy.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyy.music.common.Result;
import com.wyy.music.common.ResultCodeEnum;
import com.wyy.music.mapper.SongCollectRecentlyMapper;
import com.wyy.music.mapper.UserMapper;
import com.wyy.music.model.domain.SongCollectRecently;
import com.wyy.music.model.domain.User;
import com.wyy.music.service.SongCollectRecentlyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongxiaobin
 * @description 针对表【song_collect_recently】的数据库操作Service实现
 * @createDate 2023-06-05 22:07:30
 */
@Service
public class SongCollectRecentlyServiceImpl extends ServiceImpl<SongCollectRecentlyMapper, SongCollectRecently>
        implements SongCollectRecentlyService {
    @Resource
    private SongCollectRecentlyMapper songCollectRecentlyMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 保存最近播放的歌曲
     *
     * @param uid     用户id
     * @param musicId 音乐id
     * @return 请求结果
     */
    @Override
    public Result<String> saveSongRecently(String uid, String musicId) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("uid", uid);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            return Result.build("用户uid不存在", ResultCodeEnum.FAIL);
        }
        QueryWrapper<SongCollectRecently> songCollectRecentlyQueryWrapper = new QueryWrapper<>();
        songCollectRecentlyQueryWrapper.eq("uid", uid);
        songCollectRecentlyQueryWrapper.eq("music_id", musicId);
        songCollectRecentlyQueryWrapper.eq("type", 0);
        SongCollectRecently songCollectRecently1 = songCollectRecentlyMapper.selectOne(songCollectRecentlyQueryWrapper);
        // 原有已存在，那么先删除
        if (songCollectRecently1 != null) {
            songCollectRecentlyMapper.delete(songCollectRecentlyQueryWrapper);
        }
        // 保存
        SongCollectRecently songCollectRecently = new SongCollectRecently();
        songCollectRecently.setUid(uid);
        songCollectRecently.setMusicId(musicId);
        songCollectRecently.setType(0);
        boolean save = this.save(songCollectRecently);
        if (!save) {
            return Result.build("保存失败", ResultCodeEnum.FAIL);
        }
        return Result.ok("音乐id：" + musicId + " 保存成功");
    }

    /**
     * 获取最近播放的歌曲
     *
     * @param uid   用户ID
     * @param limit 数目
     * @return 音乐ID集合
     */
    @Override
    public Result<List<String>> getRecentlySong(String uid, Integer limit) {
        QueryWrapper<SongCollectRecently> songCollectRecentlyQueryWrapper = new QueryWrapper<>();
        songCollectRecentlyQueryWrapper.eq("uid", uid);
        songCollectRecentlyQueryWrapper.eq("type", 0);
        songCollectRecentlyQueryWrapper.orderByDesc("createTime");
        songCollectRecentlyQueryWrapper.last("limit " + limit);
        List<SongCollectRecently> songCollectRecentlies = songCollectRecentlyMapper.selectList(songCollectRecentlyQueryWrapper);
        List<String> list = new ArrayList<>();
        for (SongCollectRecently songCollectRecently : songCollectRecentlies) {
            list.add(songCollectRecently.getMusicId());
        }
        return Result.ok(list);
    }
}




