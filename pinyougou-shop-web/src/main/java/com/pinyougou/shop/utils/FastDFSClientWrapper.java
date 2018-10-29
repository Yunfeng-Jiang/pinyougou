package com.pinyougou.shop.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.pinyougou.shop.config.FdfsConfig;
import com.pinyougou.shop.config.GlobalConstants;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

/**
 * 工具类
 */
@Component
public class FastDFSClientWrapper {
    private final Logger logger = LoggerFactory.getLogger(FastDFSClientWrapper.class);

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private FdfsConfig fdfsConfig;

    /**
     * 上传文件
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath);
    }

    /**
     * 将一段字符串生成一个文件上传
     * @param content 文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream,buff.length, fileExtension,null);
        return getResAccessUrl(storePath);
    }

    /**
     * 封装图片完整URL地址
     * @param storePath
     * @return
     */
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = GlobalConstants.HTTP_PRODOCOL + fdfsConfig.getResHost()
                + ":" + fdfsConfig.getStoragePort() + "/" + storePath.getFullPath();
        return fileUrl;
    }

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }


}
