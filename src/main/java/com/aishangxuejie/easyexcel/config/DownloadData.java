package com.aishangxuejie.easyexcel.config;

import lombok.Data;

/**
 * @ClassName DownloadData
 * @Description:
 * @Author: CUiGM
 * @Date 2020/3/4
 * @Version V1.0
 **/
public class DownloadData {
	private String inCode;
	private String inName;
	private double ppd ;
	private String outCode;
	private String outName;

	public String getInCode() {
		return inCode;
	}

	public void setInCode(String inCode) {
		this.inCode = inCode;
	}

	public String getInName() {
		return inName;
	}

	public void setInName(String inName) {
		this.inName = inName;
	}

	public double getPpd() {
		return ppd;
	}

	public void setPpd(double ppd) {
		this.ppd = ppd;
	}

	public String getOutCode() {
		return outCode;
	}

	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}

	public String getOutName() {
		return outName;
	}

	public void setOutName(String outName) {
		this.outName = outName;
	}
}
