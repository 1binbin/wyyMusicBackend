package com.wyy.music.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyy.music.common.Result;
import com.wyy.music.model.domain.User;
import com.wyy.music.model.vo.SafeUser;

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
     * @return 用户信息
     */
    Result<SafeUser> userLogin(String phone, String password);

    /**
     * 用户注册/重置密码
     *
     * @param phone 手机号
     * @param password 密码
     * @param checkPassword 重复密码
     * @param type 0-注册 1-重置密码
     * @return 用户信息
     */
    User userRegister(String phone, String password, String checkPassword,int type);
}
