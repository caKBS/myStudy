package com.ssafy.ws06.step2;

public class MovieTest {

	public static void main(String[] args) {

		MovieManager MM = new MovieManager();

		Movie m1 = new Movie(1, "hello", "kim", "SF", 1001);
		Movie m2 = new Movie(2, "QQlo", "lee", "drama", 1002);
		SeriesMovie m3 = new SeriesMovie(3, "WWllo", "park", "netflix", 1003, 703, "murder");
		Movie m4 = new Movie(4, "EEllo", "choi", "disney", 1004);
		Movie m5 = new Movie(5, "RRllo", "lim", "apple", 1005);

		SeriesMovie m6 = new SeriesMovie(6, "QEllo", "pom", "LG", 1006, 706, "love");
		SeriesMovie m7 = new SeriesMovie(7, "hRlo", "eee", "SAMSUNG", 1007, 707, "war");
		Movie m8 = new Movie(8, "Wbllo", "qark", "SK", 1008);
		SeriesMovie m9 = new SeriesMovie(9, "mWllo", "bhoi", "DUSAN", 1009, 709, "gambling");
		SeriesMovie m10 = new SeriesMovie(10, "pOllo", "aim", "HYOSUNG", 1010, 710, "hunt");

		MM.add(m1);
		MM.add(m2);
		MM.add(m3);
		MM.add(m4);
		MM.add(m5);
		MM.add(m6);
		MM.add(m7);
		MM.add(m8);
		MM.add(m9);
		MM.add(m10);

		// getlist
		System.out.println("<getlist>");
		
		Movie[] LList = MM.getlist();

		for (int i = 0; i < 100; i++) {
			if (LList[i] == null) {
				continue;
			}
			System.out.println(LList[i]);
		}

		System.out.println("***************");

		// searchByTitle
		System.out.println("<searchByTitle>");
		
		Movie[] searchResult = MM.searchByTitle("El");

		for (int i = 0; i < 100; i++) {
			if (searchResult[i] == null) {
				continue;
			}
			System.out.println(searchResult[i]);
		}

		System.out.println("***************");

		// getRunningTimeAvg
		System.out.println("<getRunningTimeAvg>");
		
		double RTA = MM.getRunningTimeAvg();
		System.out.println(RTA);

		System.out.println("***************");

		// getMovies
		System.out.println("<getMovies>");
		
		Movie[] movieResult = MM.getMovies();

		for (int i = 0; i < 100; i++) {
			if (movieResult[i] == null) {
				continue;
			}
			System.out.println(movieResult[i]);
		}

		System.out.println("***************");

		// getSeriesMovies
		System.out.println("<getSeriesMovies>");
		
		Movie[] serMovieResult = MM.getSeriesMovies();

		for (int i = 0; i < 100; i++) {
			if (serMovieResult[i] == null) {
				continue;
			}
			System.out.println(serMovieResult[i]);
		}
	}

}

//End