package com.atguigu.gmall.service.imp;

public enum CountryEnum {
	
	ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");
	
	
	private Integer retCode;
	private String reMessage;
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	public String getReMessage() {
		return reMessage;
	}
	public void setReMessage(String reMessage) {
		this.reMessage = reMessage;
	}
	
	CountryEnum(Integer retCode,String reMessage){
		this.retCode=retCode;
		this.reMessage = reMessage;
	}
	public static CountryEnum forEach_CountryEnum(int index) {
		
		CountryEnum[] myArray =CountryEnum.values();
		for(CountryEnum element : myArray) {
			if(index == element.getRetCode()) {
				return element;
			}
		}
		return null;
	}
	
	
	
}
