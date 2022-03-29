package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_2930_힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());

		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			StringBuilder sb = new StringBuilder();
			bw.write("#" + tc + " ");

			int N = Integer.parseInt(br.readLine());
			int[] Arr = new int[1000001];
			int size = 0;
			for (int nc = 1; nc <= N; nc++) {

				String input = br.readLine();
				int order = 0;
				int toInsert = 0;
				if (input.length() == 1) {
					order = Integer.parseInt(input);
				} else {
					String[] inputS = input.split(" ");
					order = Integer.parseInt(inputS[0]);
					toInsert = Integer.parseInt(inputS[1]);
				}

				switch (order) {
				// Insert
				case 1:
					// 일단 삽입
					Arr[++size] = toInsert;
					// 자리 재배치
					int idx = size;
					// 루트까지 진행(비교대상을 루트까지)
					while (idx > 1) {
						// 무이동조건
						if (Arr[idx / 2] >= Arr[idx]) {
							break;
							// 이동조건
						} else {
							// swap
							int tmp = Arr[idx];
							Arr[idx] = Arr[idx / 2];
							Arr[idx / 2] = tmp;
							// 스왑한 위치로 idx 변경
							idx /= 2;
						}
					}
					break;
				// delete
				case 2:
					// 비었는지 확인
					if (size == 0) {
						bw.write(-1 + " ");
						break;
					}
					// 최대값 get
					bw.write(Arr[1] + " ");
					// 마지막 원소를 루트로
					Arr[1] = Arr[size--];
					// while문에서
					// leaf노드의 자식들에 대해서도 탐색하는데 평소에는 0이므로
					// 최대힙에서 원래는 영향을 끼치지 않는다.
					// 하지만 delete할때 지우지 않고 idx만 옮기는 방식으로 하면
					// 남아있는 원소들이 영향을 끼칠 수 있으므로
					// 지워줘야한다.
					Arr[size+1]=0;
					// 자리 재배치
					idx = 1;
					// 아래 while방식의 단점 :
					// leaf노드의 자식들에 대해서도 탐색하는데 평소에는 0이므로
					// 최대힙에서 원래는 영향을 끼치지 않는다.
					// 문제 조건이 최소힙 or 입력값 범위 변경 등으로 바뀌면
					// 따로 조건을 처리해줘야할 수 있다.
					
					// 새로운 방법 :
					// while문의 조건을 오른쪽 자식의 idx가 size보다 작을 때로 하기
					while (idx < size) {
						// 무이동조건
						if (Arr[idx] >= Math.max(Arr[idx * 2], Arr[idx * 2 + 1])) {
							break;
						// 이동조건
						} else {
							// 최강자 결정
							int kingIdx;
							if (Arr[idx * 2] >= Arr[idx * 2 + 1]) {
								kingIdx = 0;
							} else {
								kingIdx = 1;
							}
							// swap
							int tmp = Arr[idx];
							Arr[idx] = Arr[idx * 2 + kingIdx];
							Arr[idx * 2 + kingIdx] = tmp;
							// 스왑한 위치로 idx 변경
							idx = idx * 2 + kingIdx;
						}
					}
					break;
				}
			}
			bw.write("\n");
			// 출력
			bw.flush();
			// bw.close()하고 다시 bw쓰면 에러난다
			// 적절한 위치에 쓰면 되지만
			// 편리하게 그냥 bw.close() 쓰지 말자
		}
	}
}
//End