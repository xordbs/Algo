package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_8458_원점으로집합_D4_오윤택 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			int sum=0, cnt=0, max=0;
			
			for (int i = 0; i < N; i++) {
				
				StringTokenizer str = new StringTokenizer(br.readLine(), " ");
				arr[i]= Math.abs(Integer.parseInt(str.nextToken())) + Math.abs(Integer.parseInt(str.nextToken()));
				max=Math.max(max, arr[i]);
				if( i != 0 && arr[i]%2 != arr[i-1]%2)  cnt = -1;
			}
			
			if(cnt==0) {
				while(true) {
					boolean chked=true;
					
					if(sum < max || (max - sum)%2 != 0) chked=false;
					if(chked) break;
					
					sum += ++cnt;
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
