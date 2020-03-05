package com.aishangxuejie.easyexcel.listener;

import com.aishangxuejie.easyexcel.config.DownloadData;
import com.aishangxuejie.easyexcel.respository.UploadDAO;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UploadDataListener
 * @Description:
 * @Author: CUiGM
 * @Date 2020/3/5
 * @Version V1.0
 **/
public class UploadDataListener extends AnalysisEventListener<DownloadData> {
	private static final Logger log = LoggerFactory.getLogger(UploadDataListener.class);
	/**
	 * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
	 */
	private static final int BATCH_COUNT = 500;
	List<DownloadData> list = new ArrayList<>();

	private UploadDAO uploadDAO;

	public UploadDataListener(UploadDAO uploadDAO) {
		this.uploadDAO = uploadDAO;
	}

	@Override
	public void invoke(DownloadData downloadData, AnalysisContext analysisContext) {
		log.info("解析到一条数据：{}",JSON.toJSONString(downloadData));
		list.add(downloadData);
		if (list.size() >= BATCH_COUNT)
			list.clear();
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		saveData();
		log.info("所有数据解析完成！");

	}
	/**
	 * 加上存储数据库
	 */
	private void saveData() {
		log.info("{}条数据，开始存储数据库！", list.size());
		List<DownloadData> allList = uploadDAO.save(list);
		log.info("存储数据库成功！");
	}
}
