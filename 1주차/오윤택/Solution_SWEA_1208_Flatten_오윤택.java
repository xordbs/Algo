package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1208_Flatten_오윤택 {
	
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);    
         
        for (int i = 1; i <= 2; i++) {
            int counting = sc.nextInt();
            int[] arr = new int[100];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            int maxnum=0, minnum=0;
            for (int j = 0; j <=counting; j++) {
                
            	if(j != 0) {
                    arr[maxnum]--;
                    arr[minnum]++;
            	}
            	int max = 0, min = 101;
                for (int k = 0; k < arr.length; k++) {

                    if(arr[k] < min) {
                        min = arr[k];
                        minnum = k;
                    }
                    if(arr[k] > max) {
                        max = arr[k];
                        maxnum = k;
                    }
                }
//                if(j == counting-1) break;
                if(arr[maxnum]-arr[minnum] == 0 || arr[maxnum]-arr[minnum] == 1) break;

            }
            StringBuilder sb = new StringBuilder();
            sb.append("#"+i+" ").append(arr[maxnum]-arr[minnum]);
            System.out.println(sb);
        }
    }
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);	
//		
//		for (int i = 1; i <= 10; i++) {
//			int counting = sc.nextInt();
//			int[] arr = new int[100];
//			for (int j = 0; j < arr.length; j++) {
//				arr[j] = sc.nextInt();
//			}
//			
//			for (int j = 0; j < counting; j++) {
//				Arrays.sort(arr);
//				arr[0]++;
//				arr[99]--;
//			}
//			
//			Arrays.sort(arr);			
//			StringBuilder sb = new StringBuilder();
//			sb.append("#"+i+" ").append(arr[99]-arr[0]);
//			System.out.println(sb);
//		}
//		
//	}
}

//#1 13
//#2 32
//#3 54
//#4 25
//#5 87
//#6 14
//#7 39
//#8 26
//#9 13
//#10 29

