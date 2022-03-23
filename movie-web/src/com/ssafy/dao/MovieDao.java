package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.Movie;

public interface MovieDao {

	// 영화 등록
	public void insertMovie(Movie movie);

	// 영화 업데이트
	public void updateMovie(Movie movie);

	// 영화 삭제
	public void deleteMovie(int id);

	// 영화 상세보기
	public Movie selectOne(int id);

	// 영화 전체보기
	public List<Movie> selectAll();
}
