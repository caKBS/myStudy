package com.ssafy.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {
			// 몇번째 case인지 -> 불필요
			int caseNum = sc.nextInt();
			Queue<Integer> Q = new LinkedList<Integer>();
			// 입력 받아 놓기
			for (int in = 0; in < 8; in++) {
				Q.add(sc.nextInt());
			}
			//마지막 데이터가 0일때 상황이 종료되므로
			//마지막 데이터를 탈출 조건으로 사용
			int lastItem = -1;
			while (lastItem != 0) {
				//한 사이클 실행
				for (int cycle = 1; cycle <= 5; cycle++) {
					//poll해서 N감소 시킨 값(후보)
					int candi = Q.poll() - cycle;
					//후보가 0이하이면 마지막 데이터로 0을 넣고
					// 즉시 상황 종료
					if (candi <= 0) {
						lastItem = 0;
						Q.add(lastItem);
						break;
					// 종료상황아니면 후보를 큐에 add
					} else {
						lastItem=candi;
						Q.add(lastItem);
					}
				}
			}
			System.out.printf("#%d ", tIdx);
			for (int i = 0; i < 8; i++) {
			System.out.print(Q.poll()+" ");
			}
			System.out.println();
		}
	}
}
//End