package 백준;

import java.util.Scanner;
/*
 * 176ms
 */
public class Main_BOJ_1149_RGB거리_오윤택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] dp = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
				int r = sc.nextInt();
				int g = sc.nextInt();
				int b = sc.nextInt();
				
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) +r;
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) +g;
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) +b;
		}
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		sc.close();
	} // end of main
} // end of class
