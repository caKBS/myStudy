package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1278_자릿수계산 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1;
		
		while(true) {
			if (n/10 == 0) {
				break;
			}
			n = n/10;
			count++;
		}
		
		System.out.printf("%d",count);
	}

}
// End 