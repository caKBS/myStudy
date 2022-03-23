package com.ssafy.boj.y22.m01_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class boj_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int orderNum = Integer.parseInt(br.readLine());
		int[] stack = new int[orderNum];

		// pointer는 최상단 데이터 바로 위에 위치 하도록.
		int pointer = 0;
		for (int i = 0; i < orderNum; i++) {
			String input = br.readLine();
			String[] order = input.split(" ");
			
			if (order[0].equals("push")) {
				stack[pointer++] = Integer.parseInt(order[1]);
			} else if (order[0].equals("pop")) {
				if (pointer == 0) {
					System.out.println(-1);
				} else {
					System.out.println(stack[--pointer]);
				}
			} else if (order[0].equals("size")) {
				System.out.println(pointer);
			} else if (order[0].equals("empty")) {
				if (pointer == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (order[0].equals("top")) {
				if (pointer == 0) {
					System.out.println(-1);
				} else {
					System.out.println(stack[pointer - 1]);
				}
			}
		}
	}
}
// End
