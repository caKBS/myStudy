package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1208_Flatten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {

			// dump횟수
			int dumpNum = sc.nextInt();

			// 입력 받아서 배열 만들기
			int[] Board = new int[100];
			for (int bidx = 0; bidx < 100; bidx++) {
				int newtower = sc.nextInt();
				Board[bidx] = newtower;
			}

			int maxIdx = 0;
			int minIdx = Board.length;
			// dump하기
			// for문을 while문으로 바꾸면 탈출을 if에서만 할 수 있게하여
			// maxIdx = maxIdx(Board);,minIdx = minIdx(Board);
			// 를 두번쓰는 걸 피할 수 있다.
			for (int dumpIdx = 0; dumpIdx < dumpNum; dumpIdx++) {
				// 최대값을 갖는 idx, 최소값을 갖는 idx
				maxIdx = maxIdx(Board);
				minIdx = minIdx(Board);
				// flatten완료되면 탈출
				if ((Board[maxIdx] - Board[minIdx]) <= 1) {
					break;
				}
				// dump
				Board[maxIdx]--;
				Board[minIdx]++;
			}

			// 마지막 덤프를 한 후 최대최소를 한번 더 업데이트하고 출력해야함.
			maxIdx = maxIdx(Board);
			minIdx = minIdx(Board);
			System.out.printf("#%d %d\n", tIdx, Board[maxIdx] - Board[minIdx]);
		}
	}

	// max값을 가지는 인덱스 리턴
	public static int maxIdx(int[] Board) {
		// [max,max_idx]
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < Board.length; i++) {
			int freshman = Board[i];
			if (max < freshman) {
				max = freshman;
				maxIdx = i;
			}
		}
		return maxIdx;
	}

	// min값을 가지는 인덱스 리턴
	public static int minIdx(int[] Board) {
		int min = Integer.MAX_VALUE;
		int minIdx = Board.length;
		for (int i = 0; i < Board.length; i++) {
			int freshman = Board[i];
			if (min > freshman) {
				min = freshman;
				minIdx = i;
			}
		}
		return minIdx;
	}
}
//End