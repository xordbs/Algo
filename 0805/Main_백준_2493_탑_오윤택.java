package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_백준_2493_탑_오윤택 {

	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(sc.readLine()); // 갯수 입력
		
		Stack<Integer> stack = new Stack<Integer>(); // 처음에 담을 스택 선언
		Stack<Integer> indexStack = new Stack<Integer>(); // 인덱스 스택 선언
		
		int num = 0; // 임시 저장 
//		int index = 0;
		StringTokenizer str = new StringTokenizer(sc.readLine(), " ");
		for (int i = 1; i <= N; i++) { // 입력 횟수만큼 반복
			int bd = Integer.parseInt(str.nextToken());
			
			if(stack.empty()) { // 스택이 비어있으면 
				sb.append(0).append(" "); // 0을 sb에 저장
				stack.push(bd); // 스택에 빌딩 높이 저장
				indexStack.push(i); // 빌딩에 맞는 인덱스 값 저장
			}else { // 스택이 비어있지 않으면
				while(true) { // 반복문 
					if(stack.empty()) { // 반복 과정중 스택이 빈 경우
						sb.append(0).append(" "); // sb에 0 저장
						stack.push(bd); // 스택에 빌딩 높이 저장
						indexStack.push(i); // 빌딩에 맞는 인덱스 저장
						break; // 반복문 탈출
					}
					num = stack.peek(); // 스택이 비어있지 않다면 스택의 가장 윗 값을 확인 후 num에 입력
					if(num > bd) { // 현재 입력으로 들어온 빌딩의 높이가 스택의 가장 윗 값보다 작은 경우
						sb.append(indexStack.peek()).append(" "); // sb에 인덱스 값을 저장
						stack.push(bd); // 스택에 빌딩 높이 저장
						indexStack.push(i); // 인덱스 스택에 빌딩에 맞는 인덱스 저장
						break; // 반복문 탈출
					}else { // 현재 입력으로 온 빌딩의 높이이 스택의 가장 윗값이 크다면
						stack.pop(); // 현재 입력보다 높은 값을 찾기 위해 스택의 가장 윗값 삭제
						indexStack.pop(); // 인덱스도 제거
					}
				} // end of while
			} // end of if
		} // end of for
		System.out.println(sb);
		sc.close();
	} // end of main
} // end of class
