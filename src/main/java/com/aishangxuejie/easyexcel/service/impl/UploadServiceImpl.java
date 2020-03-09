package com.aishangxuejie.easyexcel.service.impl;

import com.aishangxuejie.easyexcel.config.DownloadData;
import com.aishangxuejie.easyexcel.respository.UploadRepository;
import com.aishangxuejie.easyexcel.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName UploadServiceImpl
 * @Description:
 * @Author: CUiGM
 * @Date 2020/3/6
 * @Version V1.0
 **/
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadRepository uploadRepository;

	@Override
	public int save(List<DownloadData> downloadData) {
		return uploadRepository.save(downloadData);
	}
}
