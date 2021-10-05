package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soultion_SWEA_4014_활주로건설_오윤택 {
	
	static int N;
	static int X;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			N = Integer.parseInt(str.nextToken()); // 배열 크기
			X = Integer.parseInt(str.nextToken()); // 경사로 길이
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) { // 가로
				if(chked1(map, i)) cnt++;
				if(chked2(map, i)) cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}
		
	}
	
	private static boolean chked1(int[][] arr, int k){
		int count = 1;
		int height = map[k][0]; // 가로 첫번째

		for (int i = 1; i < N; i++) {
			if (height == map[k][i]) count++; // 높이 같으면 계속 카운트
			else if (map[k][i] - height == 1) {// 크면
				if (count < X)  return false; // 경사로 카운트 한것보다 경사가 더 크면 패스
				else {
					count = 1;//다시 1
					height = map[k][i];//이제 중간 검사
				}
			} else if (height - map[k][i] == 1) {// 작으면
				if (N < X + i) return false; //경사로가 범위를 벗어나면 패스
				
				// 경사로가 범위를 벗어나지 않으면 경사로가 들어가는 자리에 더 큰 차이가 나는 높이가 있는지 체크
				for (int j= i; j < X+i; j++) { 
					if (height - map[k][j] != 1) return false; //1보다 차이 많이나면 버림
				}
				i += X-1; //확인 한만큼 i에 더해줌
				height = map[k][i];
				count = 0;
			} else {// 경사 2 이상은 패스
				return false;
			}
		}		
		
		return true;
	}
	
	private static boolean chked2(int[][] arr, int k){ // 세로
		int count = 1;
		int height = map[0][k];

		for (int i = 1; i < N; i++) {
			if (height == map[i][k]) count++; // 높이 같으면 계속 카운트
			else if (map[i][k] - height == 1) {// 크면
				if (count < X)  return false; // 경사로 카운트 한것보다 경사가 더 크면 패스
				else {
					count = 1;//다시 1
					height = map[i][k];//이제 중간 검사
				}
			} else if (height - map[i][k] == 1) {// 작으면
				if (N < X + i) return false; //경사로가 범위를 벗어나면 패스
				
				// 경사로가 범위를 벗어나지 않으면 경사로가 들어가는 자리에 더 큰 차이가 나는 높이가 있는지 체크
				for (int j= i; j < X+i; j++) { 
					if (height - map[j][k] != 1) return false; //1보다 차이 많이나면 버림
				}
				i += X-1; //확인 한만큼 i에 더해줌
				height = map[i][k];
				count = 0;
			} else {// 경사 2 이상은 패스
				return false;
			}
		}		
		return true;
	}
}
