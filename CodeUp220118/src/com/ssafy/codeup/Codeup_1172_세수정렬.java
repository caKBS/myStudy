package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1172_세수정렬 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int fst = sc.nextInt();
		int snd = sc.nextInt();
		int trd = sc.nextInt();
		int buf;
		boolean running = true;

		while (running) {

			if (fst >= snd) {
				buf = snd;
				snd = fst;
				fst = buf;

			}
			if (snd >= trd) {
				buf = trd;
				trd = snd;
				snd = buf;
			}

			if ((fst <= snd) && (snd <= trd)) {
				running = false;
			}
		}

		System.out.printf("%d %d %d", fst, snd, trd);

	}

}
// End