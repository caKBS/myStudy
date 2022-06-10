package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_14888_연산자끼워넣기_dfs {

	public static int N;
	public static int maxVal;
	public static int minVal;
	public static int[] sel;
	public static int[] ops;
	public static int[] nums;
	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 최대, 최소 초기화
		maxVal = Integer.MIN_VALUE;
		minVal = Integer.MAX_VALUE;

		N = Integer.parseInt(br.readLine());
		// 숫자 배열
		nums = new int[N];
		String[] A = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(A[i]);
		}

		String[] oper = br.readLine().split(" ");
		// 연산자 개수 배열
		ops = new int[4];
		for (int i = 0; i < 4; i++) {
			ops[i] = Integer.parseInt(oper[i]);
		}
		
		// 첫 파라미터 sum값에는 nums[0]가 들어가야 함.
		// 0번째 선택에선 sum이 nums[0]이다.
		dfs(0,nums[0]);
		
		// 출력
		System.out.println(maxVal);
		System.out.println(minVal);

	}

	
	// sidx : 현재 선택이 몇번째인지, sum : 현재 번째에서의 sum
	public static void dfs(int sidx, int sum) {
		// 연산자 개수는 N-1개
		if(sidx==N-1) {
			// 연산 완료
			maxVal = Math.max(maxVal, sum);
			minVal = Math.min(minVal, sum);
			
			return;
		}

		for (int op = 0; op < 4; op++) {

			if (ops[op] > 0) {
				
				// 이번 선택에선 이 연산자를 사용한다
				ops[op]--;

				switch (op) {
				// '+'
				case 0:
					dfs(sidx + 1, sum + nums[sidx + 1]);
					break;
				// '-'
				case 1:
					dfs(sidx + 1, sum - nums[sidx + 1]);
					break;
				// '*'
				case 2:
					dfs(sidx + 1, sum * nums[sidx + 1]);
					break;
				// '/'
				case 3:
					dfs(sidx + 1, sum / nums[sidx + 1]);
					break;
				}
				
				// 재귀에서 다시 돌아왔을때 재귀에서 썼던 연산자는
				// 안쓴 것이 된다.
				ops[op]++;
			}
		}
	}

}
//End