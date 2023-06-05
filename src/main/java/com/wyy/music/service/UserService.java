package com.wyy.music.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyy.music.model.domain.User;

/**
 * @author hongxiaobin
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-06-03 09:59:30
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return
     */
    User userLogin(String phone, String password);
}
