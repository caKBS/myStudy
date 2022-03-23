package com.ssafy.ws07.step2;


public class MovieManagerImpl implements IMovieManager {

	private static int MAX_SIZE = 100;
	private Movie[] movielist = new Movie[MAX_SIZE];
	private int size = 0;
	private static IMovieManager instance = new MovieManagerImpl();
	// 사용한 두 type이 올바른지 확인 필요?ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	
	private MovieManagerImpl() {}
	
	public static IMovieManager getMM() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		if (size < MAX_SIZE) {
			movielist[size++] = movie;
		}

	}

	@Override
	public Movie[] getList() {
		return movielist;
	}

	@Override
	public Movie[] searchByTitle(String title) {
		Movie[] searchList = new Movie[MAX_SIZE];
		int count = 0;

		for (int i = 0; i < size; i++) {

			if (movielist[i].getTitle().contains(title)) {
				searchList[count++] = movielist[i];
			}
		}
		return searchList;
	}

	@Override
	public Movie[] getMovies() {
		Movie[] pureMovie = new Movie[MAX_SIZE];
		int count = 0;
		for (int i = 0; i < size; i++) {

			if (!(movielist[i] instanceof SeriesMovie)) {
				pureMovie[count++] = movielist[i];
			}
		}

		return pureMovie;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		SeriesMovie[] SerMovie = new SeriesMovie[MAX_SIZE];
		int count = 0;
		for (int i = 0; i < size; i++) {

			if (movielist[i] instanceof SeriesMovie) {
				SerMovie[count++] = (SeriesMovie) movielist[i];
			}
		}

		return SerMovie;
	}

	@Override
	public double getRunningTimeAvg() {
		double rtSum = 0;

		for (int i = 0; i < size; i++) {
			rtSum = rtSum + movielist[i].getRunningTime();
		}

		return (rtSum / size);
	}


}
