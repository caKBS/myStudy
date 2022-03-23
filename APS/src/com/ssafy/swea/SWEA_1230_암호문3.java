package com.ssafy.swea;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1230_암호문3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {
			int N = sc.nextInt();
			List<Integer> code = new LinkedList<Integer>();
			// idx0는 비워두기
			code.add(-1);
			// 입력 암호를 LinkedList에 채워넣기
			for (int nIdx = 0; nIdx < N; nIdx++) {
				code.add(sc.nextInt());
			}
			// 명령어 개수
			int instrNum = sc.nextInt();
			for (int itrIdx = 0; itrIdx < instrNum; itrIdx++) {
				// 명령어
				char instr = sc.next().charAt(0);
				// x위치
				int targetIdx;
				// y개
				int inNum;
				// 삽입일때
				if (instr == 'I') {
					targetIdx = sc.nextInt();
					inNum = sc.nextInt();
					// s를 목표지점에 삽입
					// (LinkedList의 기존 마지막 idx)+1에
					// add하는 것을 .add(idx,element)로 가능.
					for (int iIdx = 0; iIdx < inNum; iIdx++) {
						code.add(++targetIdx, sc.nextInt());
					}
				}
				// 삭제일때
				else if (instr == 'D') {
					targetIdx = sc.nextInt();
					inNum = sc.nextInt();
					for (int iIdx = 0; iIdx < inNum; iIdx++) {
						code.remove(++targetIdx);
					}

				}
				// 추가일때
				else if (instr == 'A') {
					inNum = sc.nextInt();
					for (int iIdx = 0; iIdx < inNum; iIdx++) {
						code.add(sc.nextInt());
					}
				}
			}
			System.out.printf("#%d ", tIdx);
			for (int i = 1; i <= 10; i++) {
				System.out.printf("%d ", code.get(i));
			}
			System.out.println();
		}
	}
}
//End