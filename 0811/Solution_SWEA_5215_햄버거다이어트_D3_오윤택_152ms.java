package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_오윤택_152ms {

	static int TC, MaxNum, MaxCal, sum;
	
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TC; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			
			MaxNum = Integer.parseInt(str.nextToken());
			MaxCal = Integer.parseInt(str.nextToken());
			sum = 0;
			arr = new int[MaxNum][2];
			for (int j = 0; j < MaxNum; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			sum = 0;
			best(0, 0, 0);
			sb.append("#").append(i).append(" ").append(sum);
			System.out.println(sb);
		}
		
	}
	
	public static void best(int valueSum, int CalSum, int cnt) {
		if(valueSum >= sum && CalSum <= MaxCal) {
				sum = valueSum;
		}
		
		if(MaxNum ==cnt) return;
		
		for (int i = cnt; i < MaxNum; i++) {
			if(CalSum+arr[i][1] <= MaxCal) {
				best(valueSum+arr[i][0], CalSum+arr[i][1], i+1);
			}
		}
	}
}
