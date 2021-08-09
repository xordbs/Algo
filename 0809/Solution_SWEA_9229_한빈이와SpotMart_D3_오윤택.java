package SWEA;

import java.util.Scanner;

public class Solution_SWEA_9229_한빈이와SpotMart_D3_오윤택 {

	static int TC;
	static int gram;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			int inputCase = sc.nextInt(); // 과자 갯수
			gram = sc.nextInt(); // 들고갈수 있는 최대 중량
			int arr[] = new int[inputCase]; // 과자별 무게
			for (int j = 0; j < inputCase; j++) {
				arr[j] = sc.nextInt();
			}
			
			int max = -1;
			for (int a = 0; a < arr.length; a++) {
				for (int b = a+1; b < arr.length; b++) {
					if(arr[a] + arr[b] > gram) continue;
					max = (arr[a] + arr[b])>= max?(arr[a]+arr[b]):max;
				}
			}
			System.out.println("#"+i+" "+max);
		}
	sc.close();	
	}
	
}
