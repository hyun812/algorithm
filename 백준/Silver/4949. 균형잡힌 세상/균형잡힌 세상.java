
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		while( !(line = bf.readLine()).equals(".")) {
			check(line);
		}
		
		System.out.println(sb.toString());
	}
	
	private static void check(String s) {
		Stack<String> stack = new Stack<>();
		String[] sarr = s.split("");
		
		for(int i=0; i<sarr.length; i++) {
			String target = sarr[i];
			
			if(target.equals("(") || target.equals("[")) {
				stack.add(target);
			}
			else if(target.equals(")") || target.equals("]")) {
				if(stack.isEmpty()) {
					sb.append("no").append("\n");
					return;
				}else {
					if(target.equals(")")){
						if(stack.peek().equals("(")) {
							stack.pop();
						}else {
							sb.append("no").append("\n");
							return;		
						}
					}else if(target.equals("]")){
						if(stack.peek().equals("[")) {
							stack.pop();
						}else {
							sb.append("no").append("\n");
							return;		
						}
					}
					
				}
			}
		}
		
		if(!stack.isEmpty()) {
			sb.append("no").append("\n");
			return;
		}
		
		sb.append("yes").append("\n");
		return;
	}
}
