package SWEA;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1953_탈주범검거_오윤택_128ms {
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static LinkedList<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			int r = Integer.parseInt(str.nextToken());
			int c = Integer.parseInt(str.nextToken());
			int time = Integer.parseInt(str.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			int count = 1;
			q = new LinkedList<int[]>();
			q.add(new int[] { r, c });
			visited[r][c] = true;
			while (time > count) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] arr = q.poll();
					int d = map[arr[0]][arr[1]];
					for (int j = 0; j < dr.length; j++) {
						int nr = arr[0] + dr[j];
						int nc = arr[1] + dc[j];
						// 범위 체크 및 map의 값이 0 또는 이미 방문한 배열 패스
						if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue; 
						
						find(j, d, nr, nc);
					}
				}
				count++;
			}
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						res++;
					}
				}
			}
			System.out.println("#"+tc+" "+res);
		}
	}
	// 상하좌우 별 올수 있는 번호 계산 후 q에 좌표 추가
	private static void find(int j, int d, int nr, int nc) {
		int val = map[nr][nc];
		switch (j) {
		case 0:
			if (d == 1 || d == 2 || d == 4 || d == 7) {
				if (val == 1 || val == 2 || val == 5 || val == 6) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
			break;
		case 1:
			if (d == 1 || d == 2 || d == 5 || d == 6) {
				if (val == 1 || val == 2 || val == 4 || val == 7) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
			break;
		case 2:
			if (d == 1 || d == 3 || d == 6 || d == 7) {
				if (val == 1 || val == 3 || val == 4 || val == 5) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
			break;
		case 3:
			if (d == 1 || d == 3 || d == 4 || d == 5) {
				if (val == 1 || val == 3 || val == 6 || val == 7) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
			break;
		}
		
	}

}

//#1 5
//#2 15
//#3 29
//#4 67
//#5 71
