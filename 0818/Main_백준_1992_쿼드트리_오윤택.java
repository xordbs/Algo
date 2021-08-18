package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1992_쿼드트리_오윤택 {

	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		sb = new StringBuilder();
		quadTree(0,0,N);
		System.out.println(sb);
	} // end of main

	private static void quadTree(int r, int c, int n) {
		if(chk(r, c, n)) {
			sb.append(map[r][c]); // 검사에서 검사 구역의 값이 동일하다면 값을 출력하고 리턴
			return;
		}else {
			sb.append("(");
			quadTree(r, c, n/2 ); //왼쪽위
			quadTree(r, c+n/2, n/2 ); // 오른쪽 위
			quadTree(r+n/2, c, n/2 ); // 왼쪽 아래
			quadTree(r+n/2, c+n/2, n/2 ); // 오른쪽 아래
			sb.append(")");
		}
		
	}
	
	// 4분할 된 구역의 값이 동일한지 다른지 검사
	private static boolean chk(int x, int y, int n) {
		int value = map[x][y];
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if(value != map[i][j]) return false;
			}
		}
		return true;
	}
}// end of class
