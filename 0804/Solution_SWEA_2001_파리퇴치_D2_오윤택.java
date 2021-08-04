package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_D2_오윤택 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			String ic = br.readLine();
			StringTokenizer str = new StringTokenizer(ic, " ");
			int N = Integer.parseInt(str.nextToken());
			int[][] arr = new int[N][N];
			int cnt = Integer.parseInt(str.nextToken());
			int sum = 0, max = 0;
			
			for (int a = 0; a < N; a++) {
				String line = br.readLine();
				StringTokenizer strLine = new StringTokenizer(line, " ");
				for (int b = 0; b < N; b++) {
					arr[a][b] = Integer.parseInt(strLine.nextToken());
				}
			}
			
			for (int a = 0; a < N-(cnt-1); a++) {
				for (int b = 0; b < N-(cnt-1); b++) {
					for (int r = a; r < a+cnt; r++) {
						for (int c = b; c < b+cnt; c++) {
							sum += arr[r][c]; 
						}
					}
					if(sum > max) {
						max = sum;
					}
					sum = 0;
				}
			}
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}

}


