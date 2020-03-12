package com.aishangxuejie.easyexcel.config;

import java.time.LocalDate;

/**
 * @ClassName SysLog
 * @Description:
 * @Author: CUiGM
 * @Date 2020/3/9
 * @Version V1.0
 **/
public class SysLog {
	private String clientIp ; // 客户端ip
	private String username ; // 操作人姓名
	private Long   operType ; // 日志类型
	private String operUrl ; // 操作的url
	private String operEvent ; // 操作事件
	private String reqParam ; // 请求参数信息
	private String reqType ; // 请求方式：POST或者GET
	private LocalDate operTime ; // 操作时间

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getOperType() {
		return operType;
	}

	public void setOperType(Long operType) {
		this.operType = operType;
	}

	public String getOperUrl() {
		return operUrl;
	}

	public void setOperUrl(String operUrl) {
		this.operUrl = operUrl;
	}

	public String getOperEvent() {
		return operEvent;
	}

	public void setOperEvent(String operEvent) {
		this.operEvent = operEvent;
	}

	public String getReqParam() {
		return reqParam;
	}

	public void setReqParam(String reqParam) {
		this.reqParam = reqParam;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public LocalDate getOperTime() {
		return operTime;
	}

	public void setOperTime(LocalDate operTime) {
		this.operTime = operTime;
	}
}
