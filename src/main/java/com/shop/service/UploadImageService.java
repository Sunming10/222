package com.shop.service;
import com.shop.config.CloudStorageConfig;

import java.io.FileInputStream;
public abstract class UploadImageService {
    protected CloudStorageConfig config;

    public abstract String uploadQNImg(FileInputStream file, String path);
}
