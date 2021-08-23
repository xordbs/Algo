package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1759_암호만들기_오윤택 {
	static int L, C, aeiou, ous;
	static char[] arr;
	static char[] isSelected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		String st = br.readLine();
		arr = new char[C];
		isSelected = new char[L];
		st = st.replaceAll(" ", "");
		for (int i = 0; i < C; i++) {
			arr[i] = st.charAt(i);
		}
		Arrays.sort(arr);
		
		com(0,0);
	}
	
	private static void com(int cnt, int start) {
		aeiou = 0;
		ous = 0;
		if(cnt == L) {
			sb = new StringBuilder();
			for (int i = 0; i < cnt; i++) {
				if(isSelected[i] == 'a' || isSelected[i] == 'e' || isSelected[i] == 'i' || isSelected[i] == 'o' || isSelected[i] == 'u') {
					aeiou++;
				}else {
					ous++;
				}
				sb.append(isSelected[i]);
			}
			if(aeiou >= 1 && ous >=2) {
				System.out.println(sb);
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			isSelected[cnt] = arr[i];
			com(cnt+1, i+1);
		}
	}
}
