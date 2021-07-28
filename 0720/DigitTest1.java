package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		boolean zero = false;
		int[] countArr = new int[10];
		while(true) {
			int num = sc.nextInt();
			if(num == 0) {
				break;
			}else {
				int result = num / 10;
				countArr[result]++;
			}
		}
		for (int i = 0; i < countArr.length; i++) {
			if(countArr[i] != 0)
				System.out.printf("%d : %d개\n", i, countArr[i]);
		}
	}
}

