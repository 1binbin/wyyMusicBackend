package com.wyy.music.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyy.music.model.domain.User;
import com.wyy.music.mapper.UserMapper;
import com.wyy.music.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hongxiaobin
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-06-03 09:59:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return
     */
    @Override
    public User userLogin(String phone, String password) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", phone);
        return userMapper.selectOne(userQueryWrapper);
    }
}




