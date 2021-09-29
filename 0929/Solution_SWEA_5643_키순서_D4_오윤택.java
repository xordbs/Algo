package SWEA;

import java.io.*;
import java.util.*;


public class Solution_SWEA_5643_키순서_D4_오윤택 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스 입력
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			int[] arr1 = new int[N+1];
			int[] arr2 = new int[N+1];
			boolean[][] chked = new boolean[N+1][N+1];
			boolean[] visited = new boolean[N+1];
			Queue<Integer> q = new LinkedList<Integer>();
			
			for (int i = 0; i < M; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(str.nextToken()); 
				int b = Integer.parseInt(str.nextToken());
				
				chked[a][b] = true;
			}
			
			for (int i = 1; i <= N; i++) {
				Arrays.fill(visited, false);
				visited[i] = true;
				q.add(i);
				while(!q.isEmpty()) {
					int val = q.poll();
					for (int j = 1; j <= N; j++) {
						if(!visited[j] && chked[val][j]) { // 키가 크거나 작거나 현재 선택된 인원을 기준으로 알 수 있는 것 체크
							visited[j] = true;
							chked[i][j] = true;
							q.add(j);

						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(chked[i][j]) arr1[i]++; // i보다 키가 작은 인원 카운트
					if(chked[j][i]) arr2[i]++; // i보다 키가 큰 인원  카운트
				}
			}
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				// 키가 작은 인원과 큰 인원의 합이 N-1(총 인원중 자기 자신을 뺀)이 되면 자신이 몇번쨰인지 알기에 cnt++
				if(arr1[i]+arr2[i] == N-1) cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
