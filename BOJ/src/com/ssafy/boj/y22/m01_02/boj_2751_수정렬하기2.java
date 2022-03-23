package com.ssafy.boj.y22.m01_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class boj_2751_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		

		List<Integer> numList = new LinkedList<>();
		numList.add(Integer.parseInt(br.readLine()));
		// 삽입정렬방식으로
		// 받은 값을 정렬된 원소들과 비교해서 
		// 적절한 위치에 삽입
		for (int nIdx = 1; nIdx < N; nIdx++) {
			int newNum = Integer.parseInt(br.readLine());
			// 맨뒤부터 스캔
			int curIdx = numList.size() - 1;
			while (true) {
				// 다 비교해도 입력보다 작은게 없으면
				// 입력이 가장 작음
				if (curIdx == -1) {
					numList.add(0, newNum);
					break;
				// 해당 원소가 입력보다 작으면 입력은
				// 그 원소 앞에 위치
				} else if (numList.get(curIdx) < newNum) {
					numList.add(curIdx + 1, newNum);
					break;
				} else {
					curIdx--;
				}
			}

		}
		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int nIdx = 0; nIdx < N; nIdx++) {
			bw.write(numList.get(nIdx)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
// End
