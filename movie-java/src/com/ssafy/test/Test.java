package com.ssafy.test;

import com.ssafy.config.MyAppSqlConfig;
import com.ssafy.dao.MovieDao;
import com.ssafy.dto.Movie;

public class Test {
	public static void main(String[] args) {

		MovieDao mapper = MyAppSqlConfig.getSqlMapper().getMapper(MovieDao.class);

//		mapper.insertMovie(new Movie(0, "이상한", "양명균", "스릴러", 100));
//		mapper.updateMovie(new Movie(6, "천재", "양명균", "스릴러", 100));
		
//		mapper.deleteMovie(3);
		
//		System.out.println(mapper.selectOne(6));
		System.out.println(mapper.selectAll());
	}
}
