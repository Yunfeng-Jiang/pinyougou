package com.pinyougou.shop.controller;

import com.pinyougou.entity.Result;
import com.pinyougou.shop.config.FdfsConfig;
import com.pinyougou.shop.utils.FastDFSClientWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/upload")
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(UploadController.class);


    @Autowired
    private FastDFSClientWrapper dfsClient;

    /**
     * 文件服务器地址
     */
    @Autowired
    private FdfsConfig fdfsConfig;


    /**
     * 上传图片
     * @param file
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upFile", method = RequestMethod.POST)
    public Result upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = null;
        try {
            //1、取文件的扩展名
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //2、执行上传处理
            String path = dfsClient.uploadFile(String.valueOf(file), extName);
            //4、拼接返回的 url 和 ip 地址，拼装成完整的 url
            url = fdfsConfig.getResHost() + path;
        } catch (Exception e) {
            logger.error("上传服务器异常！cause {}", e.getMessage());
        }
        return new Result(true, url);
    }


}
