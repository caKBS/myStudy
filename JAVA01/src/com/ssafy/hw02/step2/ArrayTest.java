package com.ssafy.hw02.step2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {

		int[] Arr = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

		for (int atom : Arr) {

			System.out.printf("%d ", atom);

		}
		System.out.print("\n");

		for (int atom : Arr) {
			if (atom % 2 == 0) {
				System.out.printf("%d ", atom);
			}
		}
		System.out.print("\n");

		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		int newNum = sc.nextInt();

		Arr[index] = newNum;
		System.out.println(Arrays.toString(Arr));

	}

}

//End
