

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++) {
			int len = Integer.parseInt(bf.readLine());
			String line = bf.readLine();
			
			int result = check(len, line);
			sb.append("#").append(i+1).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int check(int len, String line) {
		String[] arr = line.split("");
		Stack<String> stack = new Stack<>();
			
		for(int i=0; i<len; i++) {
			String target = arr[i];
			
			if(target.equals("(") || target.equals("[") || target.equals("{") || target.equals("<")) {
				stack.add(target);
			}
			else {
				if(stack.isEmpty()) return 0;
				
				if(target.equals(")")) {
					if(stack.peek().equals("(")){
						stack.pop();
					}else {
						return 0;
					}
				}else if(target.equals("]")) {
					if(stack.peek().equals("[")){
						stack.pop();
					}else {
						return 0;
					}
				}else if(target.equals("}")) {
					if(stack.peek().equals("{")){
						stack.pop();
					}else {
						return 0;
					}
				}else if(target.equals(">")) {
					if(stack.peek().equals("<")){
						stack.pop();
					}else {
						return 0;
					}
				}
			}
		}
		
		if(!stack.isEmpty()) {
			return 0;
		}
		
		return 1;
	}
}
