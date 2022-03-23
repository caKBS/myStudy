package com.ssafy.fit;

import com.ssafy.fit.view.MainUI;

//VideoReviewDao와 VideiReviewUI를 완성하시오 :)
public class App {
	public static void main(String[] args) {
		System.out.println("SSAFIT Application 시작");
		MainUI.getInstance().service();
	}
}

