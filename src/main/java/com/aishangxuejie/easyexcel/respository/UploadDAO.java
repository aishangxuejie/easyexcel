package com.aishangxuejie.easyexcel.respository;

import com.aishangxuejie.easyexcel.config.DownloadData;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UploadDAO
 * @Description:
 * @Author: CUiGM
 * @Date 2020/3/5
 * @Version V1.0
 **/
@Repository
public class UploadDAO {
	@Resource
	private MongoTemplate mongoTemplate;

	public List<DownloadData> save(List<DownloadData> list) {
		// 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
		mongoTemplate.insertAll(list);
		List<DownloadData> allList = mongoTemplate.findAll(DownloadData.class);
		return allList;
	}
}
