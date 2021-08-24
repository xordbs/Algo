package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수_D4_오윤택 {
	
	static int TC, N, M;
	static int[] p;
	static boolean[] cnting;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			int cnt = 0;
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			p = new int[N];
			cnting = new boolean[N+1];
			make();
			for (int j = 0; j < M; j++) {
				str = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				union(a,b);
			}
			for (int j = 1; j <=N; j++) cnting[find(j)] = true;
			for (int j = 1; j <=N; j++) if(cnting[j]) cnt++;
			
			System.out.println("#"+i+" "+cnt);
		}
		
	}
	
	private static void make() {
		p = new int[N+1];
		for (int i = 1; i <=N; i++) {
			p[i] = i;
		}
	}

	private static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}	
	
	private static boolean union(int a, int b) {
		int aRoot = find(a); // a의 최상위 찾ㄱㅣ
		int bRoot = find(b); // b의 최상위 찾ㄱㅣ
		
		if(aRoot == bRoot) return false; // 최상위가 같으면 false
		p[bRoot] = aRoot; // 최상위가 다르면  b의 root는 a의 root로 변경
		return true;
	}
}
