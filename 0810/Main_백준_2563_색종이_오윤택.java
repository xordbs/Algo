package 백준;

import java.util.Scanner;

public class Main_백준_2563_색종이_오윤택 {
	
	public static void main(String[] args) {
		int arr[][] = new int[100][100];
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					arr[y+j][x+k]++;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				count = arr[i][j] != 0?count+1:count;
			}
		}
		System.out.println(count);
	}
}
