package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1257_두수사이홀수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gap = b-a;
		
		for ( int i = a ; i <= b; i++) {
			if ( i%2 == 1) {
				System.out.printf("%d ", i);
			}
			
		}


	}

}
// End 