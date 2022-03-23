package com.ssafy.ws06.step2;

public class MovieManager {

	private static int MAX_SIZE = 100;
	private Movie[] movielist = new Movie[MAX_SIZE];
	private int size = 0;

	public void add(Movie movie) {
		if (size < MAX_SIZE) {
			movielist[size++] = movie;
		}
	}

	public Movie[] getlist() {
		return movielist;
	}

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

	public double getRunningTimeAvg() {
		double rtSum = 0;

		for (int i = 0; i < size; i++) {
			rtSum = rtSum + movielist[i].getRunningTime();
		}

		return (rtSum / size);

	}

}

//End