package com.wyy.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyy.music.mapper")
public class WyyMusicBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WyyMusicBackendApplication.class, args);
    }

}
