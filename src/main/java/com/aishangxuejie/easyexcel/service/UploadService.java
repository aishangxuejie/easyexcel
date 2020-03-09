package com.aishangxuejie.easyexcel.service;

import com.aishangxuejie.easyexcel.config.DownloadData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UploadService
 * @Description:
 * @Author: CUiGM
 * @Date 2020/3/6
 * @Version V1.0
 **/
@Service
public interface UploadService {

	int save(List<DownloadData> downloadData);
}
