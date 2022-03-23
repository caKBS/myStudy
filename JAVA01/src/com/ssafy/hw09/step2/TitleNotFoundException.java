package com.ssafy.hw09.step2;

public class TitleNotFoundException extends Exception {
	// checked exception과 runtime exception 중 뭐를 상속??ㅁㅁㅁㅁㅁㅁ
	private String title;
	
	public TitleNotFoundException(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}



}
