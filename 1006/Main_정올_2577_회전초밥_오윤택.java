package 정올;

import java.util.*;
import java.io.*;

public class Main_정올_2577_회전초밥_오윤택 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // 접시의 수
		int d = Integer.parseInt(str.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(str.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(str.nextToken()); // 쿠폰 번호
		
		int[] arr = new int[N];
		int[][] arr2 = new int[N][k+1];
		
		boolean[] chk = new boolean[d];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine()); // 나열된 초밥 입력

		for (int i = 0; i < N; i++) arr2[i][k]=c; // 연속된 칸의 마지막은 쿠폰번호
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < k; j++) {
				int temp = (i+j)%N; // 먹는 초밥이 어떤 초밥인지
				arr2[i][j]=arr[temp];
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int temp=0;
			Arrays.sort(arr2[i]);
			
			Arrays.fill(chk, false); //초기화
			
			for (int j = 0; j < k+1; j++) chk[arr2[i][j]-1]=true; // 가짓수는 1~d까지 이므로 -1 해주고 체크
			
			for (int j = 0; j < d; j++) {
				if(chk[j]) temp++; // 다른 가짓수++
			}
			ans = ans> temp? ans : temp; // 최대 가지수 변경
		}

		System.out.println(ans);
	}
}
