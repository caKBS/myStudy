package com.ssafy.ws09.step2;

import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

	private static int MAX_SIZE = 100;
	private List<Movie> movielist = new ArrayList<>();
	private static IMovieManager instance = new MovieManagerImpl();
	// 사용한 두 type이 올바른지 확인 필요?ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	
	private MovieManagerImpl() {}
	
	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
			movielist.add(movie) ;
	}

	@Override
	public Movie[] getList() {
		Movie[] result = new Movie[movielist.size()];
		for(int i=0; i< movielist.size();i++) {
			result[i] = movielist.get(i);
		}
		return result;
	}

	@Override
	public Movie[] searchByTitle(String title) throws TitleNotFoundException {
		Movie[] searchList = new Movie[movielist.size()];
		int count = 0;

		for (int i = 0; i < movielist.size(); i++) {

			if (movielist.get(i).getTitle().contains(title)) {
				searchList[count++] = movielist.get(i);
			}
		}
		if (count == 0 ) {
			throw new TitleNotFoundException(title);
			
		}
		return searchList;
	}

	@Override
	public Movie[] getMovies() {
		Movie[] pureMovie = new Movie[movielist.size()];
		int count = 0;
		for (int i = 0; i < movielist.size(); i++) {

			if (!(movielist.get(i) instanceof SeriesMovie)) {
				pureMovie[count++] = movielist.get(i);
			}
		}

		return pureMovie;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		SeriesMovie[] SerMovie = new SeriesMovie[movielist.size()];
		int count = 0;
		for (int i = 0; i < movielist.size(); i++) {

			if (movielist.get(i) instanceof SeriesMovie) {
				SerMovie[count++] = (SeriesMovie) movielist.get(i);
			}
		}

		return SerMovie;
	}

	@Override
	public double getRunningTimeAvg() {
		double rtSum = 0;

		for (int i = 0; i < movielist.size(); i++) {
			rtSum = rtSum + movielist.get(i).getRunningTime();
		}

		return (rtSum / movielist.size());
	}

}