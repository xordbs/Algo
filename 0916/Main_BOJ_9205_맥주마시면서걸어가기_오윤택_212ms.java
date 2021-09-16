package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9205_맥주마시면서걸어가기_오윤택_212ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=TC; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n+2][2];
			int[][] dist = new int[n + 2][n + 2];
			boolean[][] chked = new boolean[n + 2][n + 2];
			for (int i = 0; i < n+2; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 2; j++) {
					arr[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					dist[i][j] = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
					if(dist[i][j] <= 1000) chked[i][j] = true;
				}
			}
			
			for (int k = 0; k < n+2; k++) {
				for (int i = 0; i < n+2; i++) {
					if(i == k) continue;
					for (int j = 0; j < n+2; j++) {
						if(i == j || k == j ) continue;
						if(chked[i][k] && chked[k][j]) chked[i][j] = true;
					}
				}
			}
			
			System.out.println(chked[0][n+1] ? "happy" : "sad");
		}
	}
}
