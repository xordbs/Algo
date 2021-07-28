package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		// testCase 반복
		for (int tc = 1; tc <=TC; tc++) {
			
			int N = sc.nextInt(); // 배열 크기 
			int so = sc.nextInt(); // 소금쟁이 마리수
			int[][] arr = new int[N][N]; // 배열 생성
			int count = 0;
			
			// 소금쟁이 마리수 만큼 입력
			for (int i = 0; i < so; i++) {
				int[] dy = {-3, 3, 0, 0}; // 상하좌우
				int[] dx = {0, 0, -3, 3}; // 상하좌우
				int y = sc.nextInt(); // [y][x]
				int x = sc.nextInt(); // [y][x]
				int num = sc.nextInt(); // 방향 
				
				for (int j = 0; j < 3; j++) {
					if(y >= 0 && y < N && x >=0 && x < N ) {
						if(arr[y][x] == 1) break;
						y += dy[num-1];
						x += dx[num-1];
					}
					if(y >= 0 && y < N && x >=0 && x < N ) {
						if(arr[y][x] == 1) break;
						if(j == 2) arr[y][x]++;
					}
					
					switch (num) {
					case 1: dy[0] += 1;break;
					case 2: dy[1] -= 1;break;
					case 3: dx[2] += 1;break;
					case 4: dx[3] -= 1;break;
					}
				}
				
			}
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] != 0) count++;
				}
			}
			System.out.println("#"+tc+" "+count);
		}
	} // end of main
} // end of class

