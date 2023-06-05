package com.wyy.music.util;

import com.wyy.music.model.vo.SafeUser;
import com.wyy.music.model.domain.User;

/**
 * @Author hongxiaobin
 * @Time 2023/6/3 0003-11:21:08
 */
public class GetSafeUser {
    public static SafeUser getSafeUser(User user) {
        SafeUser getSafeUser = new SafeUser();
        getSafeUser.setId(user.getId());
        getSafeUser.setUid(user.getUid());
        getSafeUser.setGender(user.getGender());
        getSafeUser.setNickname(user.getNickname());
        getSafeUser.setAvatarUrl(user.getAvatarUrl());
        getSafeUser.setBirthday(user.getBirthday());
        getSafeUser.setPhone(user.getPhone());
        getSafeUser.setIsDelete(user.getIsDelete());
        return getSafeUser;
    }
}
