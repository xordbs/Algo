package 정올;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_정올_1828_냉장고_오윤택 {


	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Frige[] f = new Frige[N];
		for (int i = 0; i < N; i++) {
			f[i] = new Frige(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(f);
		int cnt = 1;
		
		Frige val = f[0];
		for (int i = 1; i < N; i++) {
			if(val.max < f[i].min) {
				val = f[i];
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	static class Frige implements Comparable<Frige>{
		int min, max;
		
		public Frige(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(Frige o) {
			int value =  this.max - o.max;
			return value;
		}
	}
}
