package com.ssafy.fit.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.ssafy.fit.exception.VideoNotFoundException;
import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.VideoReview;


//IVideoReviewDao를 상속받아 구현하세요.
// 추가기능 : json이나 ObjectStream을 이용해 파일에 리뷰들을 관리하는 기능
public class VideoReviewDao implements IVideoReviewDao {
	
	private static VideoReviewDao instance = new VideoReviewDao();
	public static VideoReviewDao getInstance() {
		return instance;
	}
	private VideoReviewDao() {
		for(int i = 1; i<=8;i++) {
			videoReviewDb.put(i, null);
		}
		
	}
	
	private static int reviewNo = 0;
	
	// 내부변수를 저장할 Map
	private HashMap<Integer, List<VideoReview>> videoReviewDb = new HashMap<>();
	

	

	@Override
	public int insertReview(VideoReview videoReview) {
		

		
		reviewNo = videoReview.getVideoNo();
		
		// 처음에는 키값이 없으므로 search 하기 전에 key를 먼저 설정해줘야함.
		// OOOOOO 미리 빈 객체를 넣어놔야한다!!!!!!!!!!!!!!!!!!!! - 빈칸 채우기ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
		if (videoReviewDb.get(reviewNo)==null) {
			
			videoReviewDb.put(reviewNo, new ArrayList<VideoReview>() ) ;
		}
		videoReview.setReviewNo(videoReviewDb.get(reviewNo).size() + 1);
		

		
		videoReviewDb.get(reviewNo).add(videoReview);
		

		


		
		return 0;
	}

	@Override
	public List<VideoReview> selectReview(int videoNo) {
	
		List<VideoReview> result = videoReviewDb.get(videoNo);
		
		return result;
	}
	
	
	
}


