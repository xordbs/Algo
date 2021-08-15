package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1974_스도쿠검증_D2_오윤택 {

	static boolean[] isSelected;
	static int[][] map;
	static int flag;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			isSelected = new boolean[9];
			map = new int[9][9];
			flag = 1;
			for (int j = 0; j < map.length; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < map.length; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			StringBuilder sb = new StringBuilder();
			// 세로
			row(0);
			if(flag == 0) {
				sb.append("#").append(i).append(" ").append(flag);
				System.out.println(sb);
				continue;
			}
			//가로
			isSelected = new boolean[9];
			col(0);
			if(flag == 0) {
				sb.append("#").append(i).append(" ").append(flag);
				System.out.println(sb);
				continue;
			}
			//3X3
			three(0);
			sb.append("#").append(i).append(" ").append(flag);
			System.out.println(sb);
		}
		
	}
	
	private static void row(int cnt) {
		if(cnt == 9) {
			return;
		}
		for (int j = 0; j < isSelected.length; j++) {
			int num = map[cnt][j];
			if(isSelected[num-1]) {
				flag = 0;
				return;
			}
			isSelected[num-1] = true;
		}
		isSelected = new boolean[9];
		
		row(cnt+1);
	}
	
	private static void col(int cnt) {
		if(cnt == 9) {
			return;
		}
		for (int j = 0; j < isSelected.length; j++) {
			int num = map[j][cnt];
			if(isSelected[num-1]) {
				flag = 0;
				return;
			}
			isSelected[num-1] = true;
		}
		isSelected = new boolean[9];
		col(cnt+1);
	}


	private static void three(int cnt) {
		
		if(cnt > 8) {
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int num = map[i+cnt][j+cnt];
				if(isSelected[num-1]) {
					flag = 0;
					return;
				}
				isSelected[num-1] = true;
			}
		}
		isSelected = new boolean[9];
		
		three(cnt+3);
	}
}
