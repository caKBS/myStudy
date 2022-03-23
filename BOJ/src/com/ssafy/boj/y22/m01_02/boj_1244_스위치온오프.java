package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;
import java.util.Stack;

public class boj_1244_스위치온오프 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int switchNum = sc.nextInt();
		int[] switchArr = new int[switchNum + 1];
		switchArr[0] = -1;
		for (int sIdx = 1; sIdx <= switchNum; sIdx++) {
			switchArr[sIdx] = sc.nextInt();
		}
		int humanNum = sc.nextInt();
		for (int hIdx = 1; hIdx <= humanNum; hIdx++) {
			int sex = sc.nextInt();
			int value = sc.nextInt();
			if (sex == 1) {
				for (int sIdx = 1; sIdx <= switchNum; sIdx++) {
					if (sIdx % value == 0) {
						switchArr[sIdx] ^= 1;
					}
				}
			} else {
				int distance = 0;
				while (value + distance <= switchNum
						&& value - distance >=1
						&& switchArr[value + distance] == switchArr[value - distance]) {
					if (distance != 0) {
						switchArr[value + distance] ^= 1;
					}
					switchArr[value - distance] ^= 1;
					distance++;
				}
			}
		}
		for (int pIdx = 1; pIdx <= switchNum; pIdx++) {
			System.out.printf("%d ", switchArr[pIdx]);
			if (pIdx % 20 == 0) {
				System.out.println();
			}
		}
	}
}
// End
