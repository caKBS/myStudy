package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1157_단어공부 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		//받은 스트링의 알파벳을 중복없이 순서대로 저장하는 배열
		int[] alpArr = new int[input.length()];
		//각 알파벳의 개수를 저장하는 배열, alpArr의 알파벳과 인덱스로 매칭
		int[] cntArr = new int[input.length()];

		//저장된 알파벳의 개수
		int saved = 0;
		//입력받은 스트링을 한글자한글자씩 받기
		for (int i = 0; i < input.length(); i++) {
			int inChar = input.charAt(i);
			//소문자를 대문자로
			if (inChar >= 97) {
				inChar -= 32;
			}
			//첫 iteration 처리
			if (saved == 0) {
				alpArr[saved] = inChar;
				cntArr[saved] = 1;
				saved++;
			} else {
				//이미 들어왔던 알파벳들과 새 알파벳을 비교
				boolean exist = false;
				for (int j = 0; j < saved; j++) {
					//같은 알파벳이 이미 존재하면 해당 알파벳 카운트+1하고 비교 종료
					if (alpArr[j] == inChar) {
						cntArr[j]++;
						exist = true;
						break;
					} else {
						continue;
					}
				}
				//같은 알파벳이 존재하지 않으면 알파벳 배열에 새로 추가
				if (exist==false) {
					alpArr[saved] = inChar;
					cntArr[saved] = 1;
					saved++;
				}
			}
		}

		// 최다 알파벳과 2번째 최다 알파벳의 개수가 같은지 확인
		int max = 0;
		int max2th = 0;
		int maxIdx = 0;
		for (int i = 0; i < input.length(); i++) {
			if (cntArr[i] >= max) {
				max2th = max;
				max = cntArr[i];
				maxIdx = i;
			} else if (cntArr[i] > max2th) {
				max2th = cntArr[i];
			}
		}

		//최다 알파벳이 여러 개 존재하면 ?를 출력, 유일하면 최다 알파벳 출력.
		char toPrint;
		if (max == max2th) {
			toPrint = '?';
		} else {
			toPrint = (char) alpArr[maxIdx];
		}

		System.out.println(toPrint);
	}

}

// End
