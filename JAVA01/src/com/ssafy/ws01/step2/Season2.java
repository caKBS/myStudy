package com.ssafy.ws01.step2;

import java.util.Scanner;

public class Season2 {
	public static void main(String[] args) {
		
		int count = 0;
		while(count<3) {
			Scanner sc = new Scanner(System.in);
			int month = sc.nextInt();
			switch (month) {
			case 3: case 4: case 5:
				System.out.printf("%d월은 봄입니다. \n", month);
				break;
			case 6: case 7: case 8:
				System.out.printf("%d월은 여름입니다. \n", month);
				break;
			case 9: case 10: case 11:
				System.out.printf("%d월은 가을입니다. \n", month);
				break;
			default:
				System.out.printf("%d월은 겨울입니다. \n", month);
			}

			count++;
		}

	}
}
// 