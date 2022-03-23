package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1159_농구경기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		// 받은 스트링의 알파벳을 중복없이 순서대로 저장하는 배열
		int[] alpArr = new int[num];
		// 각 알파벳의 개수를 저장하는 배열, alpArr의 알파벳과 인덱스로 매칭
		int[] cntArr = new int[num];
		// 5개 이상 가진 알파벳 저장
		int[] player = new int[num];

		// 저장된 알파벳의 개수
		int saved = 0;
		for (int i = 0; i < num; i++) {
			String input = sc.next();
			int inChar = input.charAt(0);
			// 첫 iteration 처리
			if (saved == 0) {
				alpArr[saved] = inChar;
				cntArr[saved] = 1;
				saved++;
			} else {
				// 이미 들어왔던 알파벳들과 새 알파벳을 비교
				boolean exist = false;
				for (int j = 0; j < saved; j++) {
					// 같은 알파벳이 이미 존재하면 해당 알파벳 카운트+1하고 비교 종료
					if (alpArr[j] == inChar) {
						cntArr[j]++;
						exist = true;
						break;
					} else {
						continue;
					}
				}
				// 같은 알파벳이 존재하지 않으면 알파벳 배열에 새로 추가
				if (exist == false) {
					alpArr[saved] = inChar;
					cntArr[saved] = 1;
					saved++;
				}
			}
		}

		//5개이상가진 알파벳만 player배열로 빼둔다.
		//go는 출전하냐 마냐를 판단한다.
		int count = 0;
		boolean go = false;
		for (int i = 0; i < saved; i++) {
			if (cntArr[i] >= 5) {
				player[count++] = alpArr[i];
				go = true;
			}
		}

		int buf = 0;
		boolean flag = true;
		// 오름차순
		while (flag) {
			flag = false;
			for (int i = 0; i < count - 1; i++) {
				if (player[i] > player[i + 1]) {
					buf = player[i];
					player[i] = player[i + 1];
					player[i + 1] = buf;
					flag = true;
				}
			}
		}

		// 

		if (go) {
			for (int i = 0; i < count; i++) {
				System.out.print((char)player[i]);
			}
		} else {
			System.out.print("PREDAJA");

		}

	}

}

// End
