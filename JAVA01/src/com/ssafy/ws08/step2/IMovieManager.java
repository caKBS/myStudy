package com.ssafy.ws08.step2;

public interface IMovieManager {

	void add(Movie movie);
	
	Movie [] getList();
	
	Movie [] searchByTitle(String title);
	
	Movie [] getMovies();
	
	SeriesMovie [] getSeriesMovies();
	
	double getRunningTimeAvg();

}
