package com.example.demo.vo;

import lombok.Data;

@Data
public class ResultData<DT> {
	private String resultCode;
	private String resultMsg;
	private DT Data;
	
	public static<DT> ResultData<DT> from(String resultCode, String resultMsg) {
	
		return from(resultCode, resultMsg, null);
	}

	public static<DT> ResultData<DT> from(String resultCode, String resultMsg, DT Data) {
		
		ResultData<DT> rd = new ResultData<>();
		rd.resultCode = resultCode;
		rd.resultMsg = resultMsg;
		rd.Data = Data;
		
		return rd;
	}
	
	public boolean isSuccess() {
		return this.resultCode.startsWith("S-");
	}
	public boolean isFail() {
		return isSuccess() == false;
	}

	
}
