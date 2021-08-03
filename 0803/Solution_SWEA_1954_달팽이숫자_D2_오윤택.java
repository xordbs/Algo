package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1954_달팽이숫자_D2_오윤택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			int num = sc.nextInt();
			int map[][] = new int[num][num];
			int cnt = 1, max = num*num;
			int x = 0, y = 0, endx = num-1, endy = num-1;
			
			while (cnt <= max) {
				// 우로
				for (int c = y; c <= endy; c++) {
					map[x][c]=cnt;
					cnt++;
				}
				x++;
				
				// 아래로
				for (int c = x; c <= endx; c++) {
					map[c][endy] = cnt;
					cnt++;
				}
				endy--;
				
				// 좌로
				for (int c = endy; c >= y; c--) {
					map[endx][c] = cnt;
					cnt++;
				}
				endx--;
				// 위로
				for (int c = endx; c >= x; c--) {
					map[c][y] = cnt;
					cnt++;
				}
				y++;
				
			} // end of while
			System.out.println("#"+i);
			for (int j = 0; j < num; j++) {
				for (int k = 0; k < num; k++) {
					System.out.print(map[j][k]+" ");
				}
				System.out.println();
			}
		}
	}
}