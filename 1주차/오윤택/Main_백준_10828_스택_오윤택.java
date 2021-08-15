package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_백준_10828_스택_오윤택 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			switch (str) {
			
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!stack.empty()) sb.append(stack.pop()); 
				else sb.append(-1);
				sb.append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				if(!stack.empty()) sb.append(0);
				else sb.append(1);
				sb.append("\n");
				break;
			case "top":
				if(!stack.empty()) sb.append(stack.peek());
				else sb.append(-1);
				sb.append("\n");
				break;
			}
			
		}
		System.out.println(sb);
	}
}
