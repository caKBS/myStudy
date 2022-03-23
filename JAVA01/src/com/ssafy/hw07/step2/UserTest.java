package com.ssafy.hw07.step2;

public class UserTest {

	public static void main(String[] args) {

		IUserManager M1 = UserManagerImpl.getUM();
		IUserManager UM = UserManagerImpl.getUM();

		User m1 = new User("hello", "kim", "SF", "lee", 1001);
		User m2 = new User("QQlo", "lee", "drama", "choi", 1002);
		VipUser m3 = new VipUser("WWllo", "park", "netflix", "WWllo",1003,"murder" ,703 );
		User m4 = new User("EEllo", "choi", "disney","WWllo", 1004);
		User m5 = new User("RRllo", "lim", "apple", "eee", 1005);

		VipUser m6 = new VipUser("QEllo", "pom", "LG", "drama",1006, "love", 706);
		VipUser m7 = new VipUser("hRlo", "eee", "SAMSUNG", "choi",1007, "war", 707);
		User m8 = new User("Wbllo", "qark", "SK", "lim", 1008);
		VipUser m9 = new VipUser("mWllo", "bhoi", "DUSAN", "hello",1009, "gambling", 709);
		VipUser m10 = new VipUser("pOllo", "aim", "HYOSUNG", "hRlo",1010, "hunt", 710);
		
		M1.add(m1);
		M1.add(m2);
		M1.add(m3);
		M1.add(m4);
		M1.add(m5);
		M1.add(m6);
		M1.add(m7);
		M1.add(m8);
		M1.add(m9);
		M1.add(m10);

		// getlist
		System.out.println("<getlist>");

		User[] LList = UM.getList();

		for (int i = 0; i < 100; i++) {
			if (LList[i] == null) {
				continue;
			}
			System.out.println(LList[i]);
		}

		System.out.println("***************");

		// searchByTitle
		System.out.println("<searchByTitle>");

		User[] searchResult = UM.searchByName("El");

		for (int i = 0; i < 100; i++) {
			if (searchResult[i] == null) {
				continue;
			}
			System.out.println(searchResult[i]);
		}

		System.out.println("***************");

		// getRunningTimeAvg
		System.out.println("<getRunningTimeAvg>");

		double RTA = UM.getAgeAvg();
		System.out.println(RTA);

		// getMovies
		System.out.println("<getMovies>");

		User[] movieResult = UM.getUser();

		for (int i = 0; i < 100; i++) {
			if (movieResult[i] == null) {
				continue;
			}
			System.out.println(movieResult[i]);
		}

		System.out.println("***************");

		// getSeriesMovies
		System.out.println("<getSeriesMovies>");

		User[] serMovieResult = UM.getVipUser();

		for (int i = 0; i < 100; i++) {
			if (serMovieResult[i] == null) {
				continue;
			}
			System.out.println(serMovieResult[i]);
		}

		System.out.println("***************");

	}

}

//End