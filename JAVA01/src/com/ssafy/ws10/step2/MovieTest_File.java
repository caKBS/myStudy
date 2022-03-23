package com.ssafy.ws10.step2;


public class MovieTest_File {

	public static void main(String[] args) {

		
        //객체 생성
		System.out.println("***************");
		
		System.out.println("<loadData>");
		
		IMovieManager MM = MovieManagerImpl.getInstance();
		
		System.out.println("<loadData_Done>");
		
		System.out.println("***************");
		

		// getlist
		System.out.println("<getlist>");

		Movie[] LList = MM.getList();

		for (int i = 0; i < 10; i++) {
			if (LList[i] == null) {
				continue;
			}
			System.out.println(LList[i]);
		}

		System.out.println("***************");

		// searchByTitle
		System.out.println("<searchByTitle>");

		
		// Movie[] searchResult  = MM.searchByTitle("PP"); 로 합치면
		// 왜 에러가 나지?????ㅁㅁㅁㅁㅁㅁㅁㅁㅁ
		Movie[] searchResult = null;
		try {
			searchResult = MM.searchByTitle("El");
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
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

		// getMovies
		System.out.println("<getMovies>");

		Movie[] movieResult = MM.getMovies();

		for (int i = 0; i < 10; i++) {
			if (movieResult[i] == null) {
				continue;
			}
			System.out.println(movieResult[i]);
		}

		System.out.println("***************");

		// getSeriesMovies
		System.out.println("<getSeriesMovies>");

		Movie[] serMovieResult = MM.getSeriesMovies();

		for (int i = 0; i < 10; i++) {
			if (serMovieResult[i] == null) {
				continue;
			}
			System.out.println(serMovieResult[i]);
		}

		System.out.println("***************");
		
		System.out.println("<saveData>");
		
		MM.saveData();
		
		System.out.println("<saveData_Done>");
		
		System.out.println("***************");

	}

}

// End