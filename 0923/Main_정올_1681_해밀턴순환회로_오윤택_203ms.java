package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로_오윤택_203ms {
	
	static int N,min;
	static boolean[] visited;
	static int[] numbers_per;
	static int[][] map;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		visited = new boolean[N];
		min = 10000;
		visited[0] = true;
		dfs(0, 0, 0);
		System.out.println(min);
	}
	
	private static void dfs(int cnt, int cur, int sum) {
		if(sum > min) return;
		if(cnt+1 == N ) {
			if(map[cur][0] != 0 && min > sum+map[cur][0] )  min = sum+map[cur][0];
			return;
		}
		for(int i=1;i<N;i++) {
			if(map[cur][i] == 0 || visited[i]) continue;
			visited[i] = true;
			dfs(cnt+1, i, sum+map[cur][i]);
			visited[i] = false;
		}
	}
}
