package com.ssafy.fit.exception;

public class VideoNotFoundException extends Exception{
	public VideoNotFoundException(int no) {
		super(no + " 영상을 찾을 수 없습니다.");
	}
}
