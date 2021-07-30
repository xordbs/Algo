package com.ssafy.happyhouse.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Environment {

	private String wrkp_addr;//주소
	private String wrkp_nm;//업체명
	
	public Environment() {}
	public Environment(String wrkp_addr, String wrkp_nm) {
		this.wrkp_addr = wrkp_addr;
		this.wrkp_nm = wrkp_nm;
	}

	public String getWrkp_addr() {
		return wrkp_addr;
	}

	public void setWrkp_addr(String wrkp_addr) {
		this.wrkp_addr = wrkp_addr;
	}

	public String getWrkp_nm() {
		return wrkp_nm;
	}

	public void setWrkp_nm(String wrkp_nm) {
		this.wrkp_nm = wrkp_nm;
	}
	@Override
	public String toString() {
		return "Environment [wrkp_addr=" + wrkp_addr + ", wrkp_nm=" + wrkp_nm + "]";
	}
	
	
	
}
