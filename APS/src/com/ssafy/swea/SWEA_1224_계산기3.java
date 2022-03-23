package com.ssafy.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224_계산기3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {
			Stack<Integer> operator = new Stack();
			List<Integer> rear = new ArrayList<Integer>();
			Stack<Integer> calcu = new Stack();

			// 스트링 입력받아서 char array로 만들기
			int StringLen = sc.nextInt();
			String StringIn = sc.next();
			char[] disc = StringIn.toCharArray();
			for (int dIdx = 0; dIdx < StringLen; dIdx++) {
				int icp = 0;
				int isp = 0;
				//')'일때만 다르게 처리하기 위한 상태변수
				boolean parenMode = false;
				// 숫자이면 스택에 쌓고 넘어가기
				if (disc[dIdx] - '0' <= 9 && disc[dIdx] - '0' >= 0) {
					rear.add(disc[dIdx] - '0');
					continue;
				}
				// icp설정
				if (disc[dIdx] == '+' || disc[dIdx] == '-') {
					icp = 1;
				} else if (disc[dIdx] == '*' || disc[dIdx] == '/') {
					icp = 2;
				} else if (disc[dIdx] == '(') {
					icp = 3;
				} else if (disc[dIdx] == ')') {
					parenMode = true;
				}
				// 입력값이 ')'가 아닐때
				if (!parenMode) {
					boolean flag = true;
					while (flag) {
						// 비었으면 연산자 스택에 쌓고 종료
						if (operator.isEmpty()) {
							operator.add((int) disc[dIdx]);
							flag = false;
						// 뭔가 있으면 확인해서 isp설정
						} else {
							if (operator.peek() == '+' || operator.peek() == '-') {
								isp = 1;
							} else if (operator.peek() == '*' || operator.peek() == '/') {
								isp = 2;
							} else if (operator.peek() == '(') {
								isp = 0;
							}
							//icp와 isp비교하여 뭘할지 결정
							if (icp > isp) {
								operator.add((int) disc[dIdx]);
								flag = false;
							} else {
								rear.add(operator.pop());
							}
						}
					}
				// 입력값이 ')'일때 할 것.
				} else {
					boolean flag = true;
					while (flag) {
						//'('를 만날때까지 pop해서 후순위표기 스택에 넣어주기
						if (operator.peek() == '(') {
							operator.pop();
							flag = false;
						} else {
							rear.add(operator.pop());
						}
					}
				}
			}
			//입력을 다받고 스택에 남은게 있으면 모두 pop해서 후순위표기 스택에 넣어주기
			while (!operator.isEmpty()) {
				rear.add(operator.pop());
			}

			//후순위표기스택이 빌때까지 실행
			while (!rear.isEmpty()) {
				//꺼낸게 숫자면 계산스택에 넣어주기
				if (rear.get(0) <= 9) {
					calcu.add(rear.get(0));
					rear.remove(0);
				} else {
					// 꺼낸게 연산자면 후순위스택에서 2개를 꺼내 연산자에 따라서 계산
					int B = calcu.pop();
					int A = calcu.pop();
					if (rear.get(0) == '+') {
						calcu.add(A + B);
						rear.remove(0);
					} else if (rear.get(0) == '-') {
						calcu.add(A - B);
						rear.remove(0);
					} else if (rear.get(0) == '*') {
						calcu.add(A * B);
						rear.remove(0);
					} else if (rear.get(0) == '/') {
						calcu.add(A / B);
						rear.remove(0);
					}
				}
			}
			//계산스택에 하나남은 값이 최종 결과.
			System.out.printf("#%d %d\n", tIdx, calcu.get(0));
		}
	}
}
//End