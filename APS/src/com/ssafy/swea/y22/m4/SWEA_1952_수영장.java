package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1952_수영장 {
	public static int d1Fee;
	public static int m1Fee;
	public static int m3Fee;
	public static int y1Fee;
	public static int minFee;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			String[] fee = br.readLine().split(" ");
			d1Fee = Integer.parseInt(fee[0]);
			m1Fee = Integer.parseInt(fee[1]);
			m3Fee = Integer.parseInt(fee[2]);
			y1Fee = Integer.parseInt(fee[3]);

			String[] planS = br.readLine().split(" ");
			// plan의 idx0은 미사용, idx13,14는 버퍼용
			int[] plan = new int[15];
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(planS[i - 1]);
			}
			// pay-1월부터 시작
			minFee = Integer.MAX_VALUE;

			// 1년권 처리는 한가지 경우이니 따로 처리한다.
			// 1년권 처리를 나중에한다.
			pay(1, "start", plan, 0);
			minFee = Math.min(minFee, y1Fee);

			// 출력
			bw.write("#" + tc + " " + minFee + "\n");
			bw.flush();
		}
	}

	// 매 케이스마다 독립적인 plan배열을 가져야 하므로
	// 재귀메서드 파라미터로 plan을 가져가야 한다.
	// 단, 이 문제에서는 plan을 건드리지 않아도 되므로 필요없긴 하다.
	public static void pay(int month, String mode, int[] plan, int totalFee) {
		// 종료조건
		if (month >= 13) {
			minFee = totalFee;
			return;
		}
		
		// 요금처리, 하나의 달은 하나의 이용권으로 처리하는게 무조건 유리
		switch (mode) {
		case "d1":
			if (plan[month] != 0) {
				// 하루권으로 이번달 처리함.
				totalFee += d1Fee * plan[month];
			}
			// 다음 갈 월 지정
			month++;
			break;

		case "m1":
			if (plan[month] != 0) {
				totalFee += m1Fee;
			}
			month++;
			break;

		case "m3":
			if (plan[month] != 0 || plan[month + 1] != 0 || plan[month + 2] != 0) {
				totalFee += m3Fee;
			}
			month = month + 3;
			break;

		case "start":
			break;
		}
		// 백트래킹
		if (totalFee >= minFee) {
			return;
		}

		// 1일권으로 처리
		pay(month, "d1", plan, totalFee);
		// 1달권으로 처리
		pay(month, "m1", plan, totalFee);
		// 3달권으로 처리
		pay(month, "m3", plan, totalFee);

		// 3달을 요금처리하면 반드시 3일이 지나야 하는데
		// 재귀메서드안에서 month를 증가시키면(요금처리를 다음달에 맡기면)
		// 3달을 요금처리하고 다음날로 가는 경우도 만들어 진다.
		// 고로 "이번달 mode"에 따라 month를 증가시키고
		// 재귀메서드에는 똑같이 month변수를 파라미터로 넣어준다.
		// 처리를 다음 dept가 아닌 이번 dept에서 하도록 한다.
	}
}
//End