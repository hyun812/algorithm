

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();
			
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			switch(a) {
			case 1 :
				int b1 = Integer.parseInt(st.nextToken());
				stack.add(b1);
				break;
			case 2 :
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					int b2 = stack.pop();
					sb.append(b2).append("\n");
				}
				break;
			case 3 :
				sb.append(stack.size()).append("\n");
				break;
			case 4 :
				if(stack.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				break;
			case 5 :
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					int b5 = stack.peek();
					sb.append(b5).append("\n");
				}
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
