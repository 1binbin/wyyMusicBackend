package com.wyy.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyy.music.model.domain.SongCollectRecently;
import com.wyy.music.service.SongCollectRecentlyService;
import com.wyy.music.mapper.SongCollectRecentlyMapper;
import org.springframework.stereotype.Service;

/**
* @author hongxiaobin
* @description 针对表【song_collect_recently】的数据库操作Service实现
* @createDate 2023-06-05 22:07:30
*/
@Service
public class SongCollectRecentlyServiceImpl extends ServiceImpl<SongCollectRecentlyMapper, SongCollectRecently>
    implements SongCollectRecentlyService{

}




