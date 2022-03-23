package com.ssafy.boj.y22.m01_02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> Q = new LinkedList<>();
		// 1~N까지의 수를 큐에 넣는다.
		for (int nIdx = 1; nIdx <= N; nIdx++) {
			Q.add(nIdx);
		}
		// 큐가 하나만 남을때까지 앞에것을 하나 제거하고
		// 다음 하나를 뒤에 넣는다.
		while (Q.size() > 1) {
			Q.poll();
			if (Q.size() == 1) {
				break;
			}
			Q.add(Q.poll());
		}
		System.out.println(Q.poll());
	}
}
// End
