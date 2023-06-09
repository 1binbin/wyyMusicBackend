package com.wyy.music.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyy.music.common.Result;
import com.wyy.music.common.ResultCodeEnum;
import com.wyy.music.exception.BusinessException;
import com.wyy.music.mapper.UserMapper;
import com.wyy.music.model.domain.User;
import com.wyy.music.model.vo.SafeUser;
import com.wyy.music.service.UserService;
import com.wyy.music.util.GetSafeUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.regex.Pattern;

import static com.wyy.music.contant.UserContant.SALT;

/**
 * @author hongxiaobin
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-06-03 09:59:30
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return 响应数据
     */
    @Override
    public Result<SafeUser> userLogin(String phone, String password) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", phone);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            log.info("Mobile number error，{}", phone);
            return Result.build(null, ResultCodeEnum.PHONE_ERROR);
        }
        if (!DigestUtils.md5DigestAsHex((SALT + password).getBytes()).equals(user.getPassword())) {
            log.info("Password error");
            return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }
        return Result.ok(GetSafeUser.getSafeUser(user));
    }

    /**
     * 用户注册/重置密码
     *
     * @param phone         手机号
     * @param password      密码
     * @param checkPassword 重复密码
     * @param type          0-注册 1-重置密码
     * @return 用户信息
     */
    @Override
    public User userRegister(String phone, String password, String checkPassword, int type) {
        // 校验
        String pattern = "/^1(3|4|5|6|7|8|9)\\d{9}$/";
        boolean matches = Pattern.matches(pattern, phone);
        if (matches) {
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR);
        }
        if (StringUtils.isAnyBlank(password, checkPassword)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
        if (!password.equals(checkPassword)) {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
        // 校验对象时候存在
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", phone);
        Long selectCount = userMapper.selectCount(userQueryWrapper);
        User user = new User();
        String md5DigestAsHex = DigestUtils.md5DigestAsHex((SALT + password).getBytes());
        if (type == 0) {
            // 注册
            if (selectCount == 0) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                user.setNickname(RandomStringUtils.randomAlphanumeric(12));
                user.setPhone(phone);
                user.setPassword(md5DigestAsHex);
                try {
                    user.setBirthday(dateFormat.parse("1900-01-01"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                user.setUid(UUID.randomUUID().toString().replace("-", ""));
                boolean save = this.save(user);
                if (save) {
                    return userMapper.selectOne(userQueryWrapper);
                }
            } else {
                throw new BusinessException(ResultCodeEnum.ACCOUNT_DUPLICATION);
            }
        } else if (type == 1) {
            // 重置密码
            if (selectCount > 0) {
                user.setPassword(md5DigestAsHex);
                int update = userMapper.update(user, userQueryWrapper);
                if (update > 0) {
                    return userMapper.selectOne(userQueryWrapper);
                }
            } else {
                throw new BusinessException(ResultCodeEnum.ACCOUNT_DUPLICATION);
            }
        } else {
            throw new BusinessException(ResultCodeEnum.DATA_ERROR);
        }
        return null;
    }
}




