package com.ssafy.fit.view;

import java.awt.Desktop;
import java.net.URI;
import java.util.List;
import java.util.Scanner;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.IVideoDao;
import com.ssafy.fit.model.dao.VideoDao;

public class VideoUI {
	private static Scanner sc = new Scanner(System.in);
	private static VideoUI instance = new VideoUI();
	public static VideoUI getInstance() {
		return instance;
	}
	private VideoUI() {}
	
	private IVideoDao videoDao = VideoDao.getInstance();
	
	public void service() {
		while (true) {
			System.out.println("--------------------");
			System.out.println("1. 영상목록");
			System.out.println("0. 이전으로");
			System.out.println("--------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				listVideo();
				break;
			case 0:
				return;
			default:
				System.out.println("입력이 잘못되었습니다.");
			}
		}
	}
	
	private void listVideo() {
		try {
			while (true) {
				List<Video> list = videoDao.selectVideo();
				System.out.println("--------------------");
				System.out.printf("전체 %d개%n", list.size());
				System.out.println("--------------------");
				for( Video v : list) {
					System.out.printf("%2d %4s %s %n", v.getNo(), v.getPart(), v.getTitle());
				}

				System.out.println("--------------------");
				System.out.println("1. 영상상세");
				System.out.println("2. 영상보기");
				System.out.println("0. 이전으로");
				System.out.println("--------------------");
				System.out.print("메뉴를 선택하세요 : ");
				int sel = sc.nextInt();
				switch (sel) {
				case 1:
					detailVideo();
					break;
				case 2:
					System.out.print("영상번호를 입력하세요 : ");
					int no = sc.nextInt();
					Video v = videoDao.selectVideoByNo(no);
					Desktop.getDesktop().browse(new URI(v.getUrl()));
					break;
				case 0:
					return;
				default:
					System.out.println("입력이 잘못되었습니다.");
				}
			}
		} catch (Exception e) {
			System.out.println("영상 조회시 문제가 발생했습니다.1");
		}
	}
	private void detailVideo() {
		try {
			System.out.print("영상번호를 입력하세요 : ");
			int no = sc.nextInt();

			Video video = videoDao.selectVideoByNo(no);

			System.out.println(video);
			System.out.println("--------------------");
			System.out.println("번호 : " + video.getNo());
			System.out.println("제목 : " + video.getTitle());
			System.out.println("운동 : " + video.getPart());
			System.out.println("영상URL : " + video.getUrl());
			System.out.println("--------------------");
			new VideoReviewUI(video.getNo()).service();
		} catch (Exception e) {
			System.out.println("영상 조회시 문제가 발생했습니다.2");
		}

	}
	
}

// End