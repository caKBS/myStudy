package com.ssafy.live;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MergeSort {
	public static int[] sorted;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		String[] inArr = br.readLine().split(" ");
		int len = inArr.length;
		int[] numArr = new int[len];
		for (int i = 0; i < len; i++) {
			numArr[i] = Integer.parseInt(inArr[i]);
		}

		// sorted배열 생성
		sorted = new int[len];

		// mergeSort하기
		mergeSort(numArr,0,len-1);
		
		bw.write(Arrays.toString(numArr));
		bw.flush();
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 좌
			mergeSort(arr, left, mid);
			// 우
			mergeSort(arr, mid + 1, right);
			// merge
			merge(arr, left, right);

		}
	}

	// 책임구역의 왼쪽끝이 left, 오른쪽끝이 right
	public static void merge(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		// idxL : 책임구역의 좌반 인덱스
		int idxL = left;
		// idxR : 책임구역의 우반 인덱스
		int idxR = mid + 1;
		// 정렬완료배열의 인덱스
		int idxS = left;

		// 좌반과 우반 원소를 하나씩 크기 비교해서 작은 원소를 정렬완료배열에 넣기(오름차순 정렬 기준)
		while (idxL <= mid && idxR <= right) {
			if (arr[idxL] <= arr[idxR]) {
				sorted[idxS++] = arr[idxL++];
			} else {
				sorted[idxS++] = arr[idxR++];
			}
		}
		
		// 남아 있는게 있으면 남은거 다 정렬완료배열에 넣기
		if(idxL<=mid) {
			for(int i=idxL; i<=mid; i++) {
				sorted[idxS++] = arr[i];
			}
		}
		if(idxR <= right) {
			for(int i=idxR; i<=right; i++) {
				sorted[idxS++] = arr[i];
			}
		}
		
		
//		// 남아 있는게 있으면 남은거 다 정렬완료배열에 넣기_while방식
//		while (idxL <= mid) {
//			sorted[idxS++] = arr[idxL++];
//		}
//		while (idxR <= right) {
//			sorted[idxS++] = arr[idxR++];
//		}

		
		// 정렬완료배열을 원래 배열에 반영
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}
}
//End