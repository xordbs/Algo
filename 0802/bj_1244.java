package 백준;

import java.util.Scanner;

public class bj_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] sw = new int[tc + 1];
		for (int i = 1; i < sw.length; i++) sw[i] = sc.nextInt();
		int student = sc.nextInt();
		
		for (int i = 0; i < student; i++) {
			int sex = sc.nextInt();
			int num = sc.nextInt();
			
			if (sex == 1) {
				for (int j = num; j < sw.length; j += num) sw[j] = sw[j] == 0? 1:0;
				
			} else if (sex == 2) {
				int a = num-1, b = num+1;
				
				while (true) {
					if (a < 1 || b >= sw.length)break;
					if (sw[a] != sw[b]) break;
					a--; b++;
					
				}
				a++; b--;
				while (a <= b) {
					sw[a] = sw[a] == 0? 1:0;
					a++;
				}
			}
		}
		for (int i = 1; i < sw.length; i++) {
			System.out.print(sw[i] + " ");
			if (i % 20 == 0) System.out.println();

		}

	}
}
