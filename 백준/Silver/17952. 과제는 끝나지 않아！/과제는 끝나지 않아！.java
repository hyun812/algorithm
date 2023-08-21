
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine()); // 이번 분기가 몇분인지를 나타내는 변수
		int ans = 0; // 결과값
		
		Stack<int[]> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			String check = st.nextToken(); // 새로운 업무 유무 판단
			
			if(check.equals("0")) { // 새로운업무가 없을 때
				if(!stack.isEmpty() && stack.peek()[1] == 0) { // stack의 최상단의 업무 시간이 0이라면 
					ans += stack.peek()[0]; // 점수를 더함
					stack.pop();
				}
				
				if(!stack.isEmpty()) {
					int[] pop = stack.pop();
					stack.add(new int[] {pop[0], pop[1]-1}); // time-1한후 다시 스택에 삽입	
				}
				
				
			}else if(check.equals("1")){ // 1이면 새로운업무존재
				int score = Integer.parseInt(st.nextToken()); // 업무 점수
				int time = Integer.parseInt(st.nextToken()); // 업무 시간
				
				stack.add(new int[] {score, time-1}); // 업무를 받자마자 바로 시작하므로 time-1
			}
		}
		
		while(!stack.isEmpty()) { // 스택이 비어있을때 까지 반복
			int[] pop = stack.pop(); 
			
			if(pop[1] > 0) continue; // 0보다 크면 continue
			
			ans += pop[0];
		}
		
		System.out.println(ans);
	}
}