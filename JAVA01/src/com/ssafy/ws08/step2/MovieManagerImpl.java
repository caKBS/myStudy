package com.ssafy.ws08.step2;

import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

	private static int MAX_SIZE = 100;
	private List<Movie> movielist = new ArrayList<>();
	private int size = 0;
	private static IMovieManager instance = new MovieManagerImpl();
	// 사용한 두 type이 올바른지 확인 필요?ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	
	private MovieManagerImpl() {}
	
	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		if (size < MAX_SIZE) {
			movielist.add(movie) ;
			size++;
		}

	}

	@Override
	public Movie[] getList() {
		Movie[] result = new Movie[size];
		for(int i=0; i<size;i++) {
			result[i] = movielist.get(i);
		}
		return result;
	}

	@Override
	public Movie[] searchByTitle(String title) {
		Movie[] searchList = new Movie[MAX_SIZE];
		int count = 0;

		for (int i = 0; i < size; i++) {

			if (movielist.get(i).getTitle().contains(title)) {
				searchList[count++] = movielist.get(i);
			}
		}
		return searchList;
	}

	@Override
	public Movie[] getMovies() {
		Movie[] pureMovie = new Movie[MAX_SIZE];
		int count = 0;
		for (int i = 0; i < size; i++) {

			if (!(movielist.get(i) instanceof SeriesMovie)) {
				pureMovie[count++] = movielist.get(i);
			}
		}

		return pureMovie;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		SeriesMovie[] SerMovie = new SeriesMovie[MAX_SIZE];
		int count = 0;
		for (int i = 0; i < size; i++) {

			if (movielist.get(i) instanceof SeriesMovie) {
				SerMovie[count++] = (SeriesMovie) movielist.get(i);
			}
		}

		return SerMovie;
	}

	@Override
	public double getRunningTimeAvg() {
		double rtSum = 0;

		for (int i = 0; i < size; i++) {
			rtSum = rtSum + movielist.get(i).getRunningTime();
		}

		return (rtSum / size);
	}

}