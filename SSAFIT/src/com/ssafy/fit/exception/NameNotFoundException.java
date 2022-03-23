package com.ssafy.fit.exception;

public class NameNotFoundException extends Exception {
	// checked exception과 runtime exception 중 뭐를 상속??ㅁㅁㅁㅁㅁㅁ
	private String name;
	
	public NameNotFoundException(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return name;
	}



}
