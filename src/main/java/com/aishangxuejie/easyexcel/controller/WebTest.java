package com.aishangxuejie.easyexcel.controller;

import com.aishangxuejie.easyexcel.config.DownloadData;
import com.aishangxuejie.easyexcel.listener.UploadDataListener;
import com.aishangxuejie.easyexcel.respository.UploadDAO;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName WebTest
 * @Description:
 * @Author: CUiGM
 * @Date 2020/3/4
 * @Version V1.0
 **/
@RestController
public class WebTest {

	@Autowired
	private UploadDAO uploadDAO;

	@GetMapping("download")
	@ResponseBody
	public void download(HttpServletResponse response) throws IOException {
		// 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		// 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
		String fileName = URLEncoder.encode("测试", "UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
		EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
	}

	private List<DownloadData> data() {
		List<DownloadData> list = new ArrayList<DownloadData>();
		for (int i = 0; i < 10; i++) {
			DownloadData data = new DownloadData();
			data.setInCode("ZX01010");
			data.setInName("测试目录名称");
			data.setPpd(0.9);
			data.setOutCode("c321231");
			data.setOutName("dd");
			list.add(data);
		}
		return list;
	}

	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file) throws IOException {
		EasyExcel.read(file.getInputStream(), DownloadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
		return "success";
	}

}
