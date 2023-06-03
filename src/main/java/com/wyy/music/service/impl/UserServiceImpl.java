package com.wyy.music.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyy.music.domain.User;
import com.wyy.music.mapper.UserMapper;
import com.wyy.music.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author hongxiaobin
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-06-03 09:59:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




