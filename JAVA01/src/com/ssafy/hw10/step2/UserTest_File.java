package com.ssafy.hw10.step2;

import com.ssafy.ws10.step2.IMovieManager;
import com.ssafy.ws10.step2.MovieManagerImpl;
import com.ssafy.ws10.step2.TitleNotFoundException;

public class UserTest_File {

	public static void main(String[] args) {

        //객체 생성
		System.out.println("***************");
		
		System.out.println("<loadData>");
		
		IUserManager UM = UserManagerImpl.getUM();
		
		System.out.println("<loadData_Done>");
		
		System.out.println("***************");
		

		// getlist
		System.out.println("<getlist>");

		User[] LList = UM.getList();

		for (int i = 0; i < 10; i++) {
			if (LList[i] == null) {
				continue;
			}
			System.out.println(LList[i]);
		}

		System.out.println("***************");

		// searchByName
		System.out.println("<searchByName>");

		User[] searchResult = null;
		try {
			searchResult = UM.searchByName("SU");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			if (searchResult[i] == null) {
				continue;
			}
			System.out.println(searchResult[i]);
		}

		System.out.println("***************");

		// getAgeAvg
		System.out.println("<getAgeAvg>");

		double gAA = UM.getAgeAvg();
		System.out.println(gAA);

		// getMovies
		System.out.println("<getUser>");

		User[] userResult = UM.getUser();

		for (int i = 0; i < 10; i++) {
			if (userResult[i] == null) {
				continue;
			}
			System.out.println(userResult[i]);
		}

		System.out.println("***************");

		// getSeriesMovies
		System.out.println("<getVipUser>");

		User[] vipUserResult = UM.getVipUser();

		for (int i = 0; i < 10; i++) {
			if (vipUserResult[i] == null) {
				continue;
			}
			System.out.println(vipUserResult[i]);
		}

		System.out.println("***************");
		
		// saveDate
		System.out.println("<saveData>");
		
		UM.saveData();

		System.out.println("<saveData_Done>");
		
		System.out.println("***************");

	}

}

//End