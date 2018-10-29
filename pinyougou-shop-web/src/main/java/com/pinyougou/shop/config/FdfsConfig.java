package com.pinyougou.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FdfsConfig {
 
    @Value("${fdfs.resHost}")
    private String resHost;
 
    @Value("${fdfs.storagePort}")
    private String storagePort;
 
    public String getResHost() {
        return resHost;
    }
 
    public String getStoragePort() {
        return storagePort;
    }
 
}
