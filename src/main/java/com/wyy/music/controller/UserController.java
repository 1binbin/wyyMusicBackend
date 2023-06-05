package com.wyy.music.controller;

import com.wyy.music.common.Result;
import com.wyy.music.common.ResultCodeEnum;
import com.wyy.music.mapper.UserMapper;
import com.wyy.music.model.domain.User;
import com.wyy.music.model.vo.SafeUser;
import com.wyy.music.service.UserService;
import com.wyy.music.util.GetSafeUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.wyy.music.contant.UserContant.SALT;

/**
 * @Author hongxiaobin
 * @Time 2023/6/3 0003-10:38:16
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;


    @GetMapping("/login")
    public Result<SafeUser> userLogin(@RequestParam() String phone,
                                      @RequestParam() String password) {
        // TODO: 2023/6/3 0003 更改为POST请求
        if (StringUtils.isAnyBlank(phone, password)) {
            log.info("Parameter is empty");
            return Result.build(null, ResultCodeEnum.DATA_ERROR);
        }
        User user = userService.userLogin(phone, password);
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
}
