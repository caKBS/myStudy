package com.ssafy.swea.y22.m4;

import java.io.IOException;
import java.util.Arrays;

import com.ssafy.swea.y22.m4.SWEA_5650_핀볼게임.dir;

public class test {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int [] pnt = new int[1];
		dir curDir = new dir('R',0,1);
		changeDir('U', curDir, pnt);
		changeDir('D', curDir, pnt);
		System.out.println(curDir);
		System.out.println(Arrays.toString(pnt));
		
		
	}
	public static void changeDir(char dir, dir curDir, int[] pnt) {
		switch (dir) {
		case 'R':
			// 포인트 적립 및 좌로 튕겨져 나가기
			pnt[0]++;
			curDir.state = 'R';
			curDir.dr = 0;
			curDir.dc = 1;
			return;
		case 'U':
			// 포인트 적립 및 상으로 튕겨져 나가기
			pnt[0]++;
			curDir.state = 'U';
			curDir.dr = -1;
			curDir.dc = 0;
			return;
		case 'L':
			// 포인트 적립 및 좌로 튕겨져 나가기
			pnt[0]++;
			curDir.state = 'L';
			curDir.dr = 0;
			curDir.dc = -1;
			return;
		case 'D':
			// 포인트 적립 및 좌로 튕겨져 나가기
			pnt[0]++;
			curDir.state = 'D';
			curDir.dr = 1;
			curDir.dc = 0;
			return;
		}
	}

}
