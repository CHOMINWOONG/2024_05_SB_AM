package com.example.demo.vo;

public class ResultData {
	
	private String resultCode;
	private String resultMsg;
	private Object Data;
	
	public static ResultData from(String resultCode, String resultMsg) {
	
		return from(resultCode, resultMsg, null);
	}

	public static ResultData from(String resultCode, String resultMsg, Object Data) {
		
		ResultData rd = new ResultData();
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
