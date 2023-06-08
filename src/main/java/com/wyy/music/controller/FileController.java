package com.wyy.music.controller;

import com.wyy.music.common.Result;
import com.wyy.music.common.ResultCodeEnum;
import com.wyy.music.model.vo.FileUpload;
import com.wyy.music.util.QiniuFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * 文件上传控制器
 *
 * @Author hongxiaobin
 * @Time 2023/6/7 0007-19:44:49
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @Autowired
    private QiniuFileUtils qiniuFileUtils;

    @PostMapping("/uploadimg")
    public Result<FileUpload> uploadImg(MultipartFile file,
                                        HttpServletRequest request) {

        String uid = request.getParameter("uid");
        String imagePath = qiniuFileUtils.upload(file, uid);
        System.out.println(imagePath);
        if (!imagePath.isEmpty()) {
            FileUpload fileUpload = new FileUpload();
            fileUpload.setUid(uid);
            fileUpload.setAvatarUrl(imagePath);
            return Result.ok(fileUpload);
        }
        return Result.build(null, ResultCodeEnum.FILE_UPLOAD_ERROR);
    }
}
