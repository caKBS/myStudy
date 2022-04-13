package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1238_Contact {
	public static int N;
	public static double E;
	public static vertex[] vArr;
	public static boolean[] check;
	public static long[] key;

	public static class vertex {
		public long x;
		public long y;

		public vertex(long x, long y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "vertex [x=" + x + ", y=" + y + "]";
		}
	}

	public static class tunnel {
		public int idx;
		public long Lsqr;

		public tunnel(int idx, long Lsqr) {
			this.idx = idx;
			this.Lsqr = Lsqr;
		}

		@Override
		public String toString() {
			return "tunnel [idx=" + idx + ", Lsqr=" + Lsqr + "]";
		}
	}

	// 연결정보 이중 배열
	// 중복 차단을 위해 목적지정보는 T/F Array로 보관ㅁㅁㅁㅁㅁㅁㅁㅁ

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			N = Integer.parseInt(br.readLine());

			vArr = new vertex[N];

			// vertex 정보 받기 (번호 : 0~V-1)
			String[] vInfo = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				long x = Integer.parseInt(vInfo[i]);
				vArr[i] = new vertex(x, -1);
			}
			vInfo = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				long y = Integer.parseInt(vInfo[i]);
				vArr[i].y = y;
			}

			// 세율
			E = Double.parseDouble(br.readLine());

			// 체크 배열
			check = new boolean[N];

			// Key 배열, 내 집단과 타 섬을 연결할 수 있는 최소 거리를 알려줌
			// 거리의 제곱값만 쓸거니까 제곱값으로 저장한다.
			// 최초에 매우 큰 값을 넣어둬야 한다.
			key = new long[N];
			for (int i = 0; i < N; i++) {
				key[i] = Long.MAX_VALUE;
			}

			// vertex0부터 시작
			double costSum = 0;
			check[0] = true;
			updateKey(0);
			// vertex0을 먼저 했으니까 for문은 N-1번만
			for (int i = 0; i < N - 1; i++) {
				// 내 집단과 연결할 수 있는 가장 가까운 친구
				double minVal = Long.MAX_VALUE;
				int minIdx = -1;
				for (int kIdx = 0; kIdx < N; kIdx++) {
					if (!check[kIdx] && key[kIdx] < minVal) {
						minVal = key[kIdx];
						minIdx = kIdx;
					}
				}
				// 방문
				check[minIdx] = true;
				// (주의) minVal을 long으로 하면 곱셈에서 소수점이하버림이 발생함.
				costSum += minVal * E;
				// key업데이트
				updateKey(minIdx);

			}

			// 출력
			bw.write("#" + tc + " " + Math.round(costSum) + "\n");
			bw.flush();
		}
	}

	// 체크 안된 애들과 나의 거리로 key배열을 업데이트한다.
	public static void updateKey(int num) {
		for (int i = 0; i < N; i++) {
			// 내가 아니고 체크 안된 애들
			if (i != num && !check[i]) {
				long distSqr = Math.abs(vArr[i].x - vArr[num].x) * Math.abs(vArr[i].x - vArr[num].x)
						+ Math.abs(vArr[i].y - vArr[num].y) * Math.abs(vArr[i].y - vArr[num].y);
				if (distSqr < key[i]) {
					key[i] = distSqr;
				}
			}
		}

	}
}
//End