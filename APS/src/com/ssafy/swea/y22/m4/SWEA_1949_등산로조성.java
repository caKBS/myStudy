package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class SWEA_1949_등산로조성 {
	public static int N;
	public static int K;
	public static int[][] mt;
	public static List<coor> maxList;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static boolean[][] check;
	public static int cut = 1;
	public static int maxRoad;
	public static int[][] test;

	public static class coor {
		public int row;
		public int col;

		public coor(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "coor [row=" + row + ", col=" + col + "]";
		}
	}

	// 블로그 작성 : 
	// 1. 오답노트
	// 2. 강사님이 알려주신 다양한 방법
	
	// * 오답 노트(나의 문제는 무엇이었을까) : 
	// 1. return을 한 곳에 두지 않고 여러 곳에 분산시키면서
	// 상태 배열 복구나 값 복구등이 꼬이고 디버깅을 어렵게 많들었다.
	// 왠만하면 return은 한 곳에 집중시키도록 주의하자.
	// 2. cutDone은 기록정보이기때문에 파라미터에 넣어줘야한다.
	// DFS(new coor(rowD, colD), false, dept + 1); -> DFS(new coor(rowD, colD), cutDone, dept + 1);
	// 3. 공사 가능여부를 판단하는 것을 DFS()로 넘어가는 것을 while안에 두어서
	// DFS() 직후 복구 처리 등의 문제를 복잡하게 만들었다.
	// flag & break를 사용해서 결정만 반복문에서 하고 실행은 반복문 밖에서 하도록 구성하여
	// 코드와 디버깅을 간단하게 만들자.
	// 4. DFS방문체크는 DFS시작할때 체크하고 return 직전에 해제하자.
	// 방문체크같은 상태변화를 본인dept에서 할지 이전dept에서 할지(내가 다음dept상태를 변화시키고 다음으로 넘어가는 것)
	// 상황마다 다르겠지만 일단 기본은 본인dept에서 처리하자!!!!
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {

		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		K = Integer.parseInt(data[1]);
		mt = new int[N][N];

		// 입력받기
		int maxVal = 0;
		for (int row = 0; row < N; row++) {
			String[] aline = br.readLine().split(" ");
			for (int col = 0; col < N; col++) {
				mt[row][col] = Integer.parseInt(aline[col]);
				maxVal = Math.max(mt[row][col], maxVal);
			}
		}

		// 최정상의 좌표 리스트 만들기
		maxList = new ArrayList<>();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (mt[row][col] == maxVal) {
					maxList.add(new coor(row, col));
				}
			}
		}

		// 각 최정상에서 모든 방향으로 출발
		maxRoad = 0;
		for (int i = 0; i < maxList.size(); i++) {
			test = new int[N][N];
			check = new boolean[N][N];
			DFS(maxList.get(i), false, 1);
		}

		// 출력
		bw.write("#" + tc + " " + maxRoad + "\n");
		bw.flush();
		}
	}

	// DFS로 하고
	public static void DFS(coor curr, boolean cutDone, int dept) {
		check[curr.row][curr.col] = true;

		// 주변부 확인
		for (int d = 0; d < 4; d++) {
			int rowD = curr.row + dr[d];
			int colD = curr.col + dc[d];
			// boundary 처리
			if (rowD >= N || rowD < 0 || colD >= N || colD < 0 || check[rowD][colD] == true) {
				continue;
			}

			// 나보다 낮으면 가기
			if (mt[rowD][colD] < mt[curr.row][curr.col]) {
				// cutDone은 상속되어야한다!!!!
				// 이전 기록에 관한 것이기 때문에!!!!
				DFS(new coor(rowD, colD), cutDone, dept + 1);

			// 나보다 낮진 않지만 cut 기회가 있다.
			} else if (cutDone == false) {
				// "내꺼-1"로 만들수있냐 없냐만 따지는 방법도 있다.
				// 다음 dept의 높이정보를 지금 정제해서 파라미터로 보내는
				// 방식도 있다.
				int tmp = mt[rowD][colD];
				boolean flag = false;
				for (int k = 0; k < K; k++) {
					mt[rowD][colD] -= cut;
					// 공사 후 갈 수 있어
					if (mt[rowD][colD] < mt[curr.row][curr.col]) {
						flag = true;
						break;
					}
				}
				// 회생 가능하면
				if (flag) {
					DFS(new coor(rowD, colD), true, dept + 1);
				}
				// 회생 불가능하면 그냥 안가기
				// 복구
				mt[rowD][colD] = tmp;
			}
		}
		// 리턴을 한 곳에만 둬서 코드를 깔끔하게 만들어야 한다.
		maxRoad = Math.max(maxRoad, dept);
		check[curr.row][curr.col] = false;
		return;

	}
}
//End