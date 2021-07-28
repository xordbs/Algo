package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bmi = 0;
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		bmi = num2+100-num1;
		System.out.println("비만수치는 "+bmi+"입니다.");
		
		System.out.println(bmi > 0 ?"당신은 비만이네요?":"살찌고오세요");
		/*
		if(bmi > 0) {
			System.out.println("당신은 비만이군요?!");
			
		}else {
			System.out.println("당신은 비만이 아닙니다. 살찌고 오세요");
		}
		*/
	}
}
