package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_13598_gravity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] Arr = new int[num];
		
	    //[idx0, idx1, idx2 ... ] == [height8, height7, height6.....]
		
		// 입력을 받아서 배열을 만들고 동시에 최대높이와 그 인덱스를 취한다.
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < num; i++) {
			Arr[i] = sc.nextInt();
			if (max < Arr[i]) {
				max = Arr[i];
				maxIdx = i;
			}
		}

		//최대 낙폭은 (자신의 높이-내 밑에 있는 블록 개수)로 구한다.
		int maxDrop = 0;
		// 90도 회전한 그림에서 보았을때 최대의 낙폭을 갖는 블록은
		//무조건 최대 높이탑 이상에 위치한 탑에서 생긴다.
		//고로 index=0부터 최대 높이 탑까지 조사한다.
		for (int i = 0; i <= maxIdx; i++) {
			// height는 90도 회전한 그림에서의 높이,
			// idx=0 -> height=8, idx=8 -> height=0
			int height = num - i - 1;
			// count == 내 밑에 존재하는 블록의 개수
			int count = 0;
			//내 밑에 존재하는 블록의 개수를 센다.
			for (int j = i + 1; j < num; j++) {
				// 내 밑에 탑 중에 나보다 높이가 같거나 높은애들의 개수가
				// 내 밑에 존재하는 블록의 개수
				if (Arr[j] >= Arr[i]) {
					count++;
				}
			}
			//낙폭은 내 높이 - 내 밑에 있는 블록 개수
			if (maxDrop < (height - count)) {
				maxDrop = (height - count);
			}
		}

		System.out.printf("%d", maxDrop);

	}

}
//End