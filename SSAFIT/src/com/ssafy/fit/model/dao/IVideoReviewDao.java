package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.VideoReview;

public interface IVideoReviewDao {
	
	int insertReview(VideoReview videoReview);
	//모든 리뷰 중 videoNo에 해당하는 VideoReview들을 모아서 리턴
	List<VideoReview> selectReview(int videoNo);
}
