package com.wyy.music;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import static com.wyy.music.contant.UserContant.SALT;

@SpringBootTest
class WyyMusicBackendApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(DigestUtils.md5DigestAsHex((SALT + "123456").getBytes()));
    }

}
