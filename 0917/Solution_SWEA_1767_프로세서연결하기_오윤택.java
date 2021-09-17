package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_1767_프로세서연결하기_오윤택 {
	static int N, max, min, tcnt;
	static int[][] map;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			tcnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
					if ((i == 0 || i == N-1 || j == 0 || j == N-1) && map[i][j] == 1)
						continue;// 가장자리 패스
					if(map[i][j] == 1) {
						list.add(new int[] {i,j});
						tcnt++;
					}
				}
			}
			line(0,0);
			System.out.println("#"+tc+" "+min);
			
			
		}
	}
	
	private static void line(int index, int cnt) {
		if (tcnt - index + cnt < max) {
			return; 
		}
		
		if (index == tcnt) {
			int res = 0;
			for (int i = 0; i < N; i++) { // 2 갯수 계산 
				for (int j = 0; j < N; j++) 
					if (map[i][j] == 2) ++res;
			}
			
			if (max < cnt) {
				max = cnt;
				min = res;
			} else if (max == cnt) {
				if (min > res) min = res;
			}
			return;
		}
		
		int[] arr = list.get(index);
		
		for (int k = 0; k < 4; k++) {
				
			if(!chked(arr[0], arr[1], k)) continue; 
			
			status(arr[0], arr[1], k, 2);
			line(index + 1, cnt + 1);
			status(arr[0], arr[1], k, 0);
			
		}
		line(index + 1, cnt);
	}
	
	private static boolean chked(int r, int c, int d) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0|| nc < 0|| nr >= N|| nc >= N) break;
			if(map[nr][nc] >= 1) return false;
		}
		return true;
	}
	
	
	private static void status(int r, int c, int d, int val) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0|| nc < 0|| nr >= N|| nc >= N) break;
			map[nr][nc] = val;
		}
	}
	
	
}
