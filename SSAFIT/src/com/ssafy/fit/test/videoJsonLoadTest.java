package com.ssafy.fit.test;

import java.util.List;

import com.ssafy.fit.exception.VideoNotFoundException;
import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.IVideoDao;
import com.ssafy.fit.model.dao.VideoDao;

public class videoJsonLoadTest {
	public static void main(String[] args) {
		IVideoDao vDao = VideoDao.getInstance();
		List<Video> list = vDao.selectVideo();
		for( Video v : list)
			System.out.println(v);
		System.out.println("------");
		try {
			System.out.println(vDao.selectVideoByNo(13));
		} catch (VideoNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}