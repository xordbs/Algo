package 백준;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_오윤택 {
	
	static int R,C;
	static int max = 0;
	static char[][] map;
	static boolean[] ABC;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		map = new char[R][C];
		ABC = new boolean[26];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		abc(0,0,1);
		System.out.println(max);
	} // end of main
	
	private static void abc(int r, int c, int cnt) {
		char value = map[r][c];
		if(ABC[value-'A'] == true) {
			max = max<=cnt?cnt:max;
			return;
		}else {
			ABC[value-'A'] = true;
			
			if(r-1 >=0 && !ABC[map[r-1][c]-'A']) {
				abc(r-1, c, cnt+1);
				ABC[map[r-1][c] -'A'] = false;
			}
			if(c-1 >=0 && !ABC[map[r][c-1]-'A']) {
				abc(r, c-1, cnt+1);
				ABC[map[r][c-1] -'A'] = false;
			}
			if(r+1 < R && !ABC[map[r+1][c]-'A']) {
				abc(r+1, c, cnt+1);
				ABC[map[r+1][c] -'A'] = false;
			}
			if(c+1 < C && !ABC[map[r][c+1]-'A']) {
				abc(r, c+1, cnt+1);
				ABC[map[r][c+1] -'A'] = false;
			}
			abc(r, c, cnt);
		}

	}
}