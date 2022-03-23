package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.exception.VideoNotFoundException;
import com.ssafy.fit.model.Video;

public interface IVideoDao {
	//video목록을 보여주기 위해 모든 video정보를 가져오는 기능
	List<Video> selectVideo();
	//하나의 video에 대한 상세정보를 보기 위해 하나의 video정보를 가져오는 기능
	Video selectVideoByNo(int no) throws VideoNotFoundException;
}
