
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<String> stack;
	static String open = "(";
	static String close = ")";
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=0; tc<t; tc++) {
			stack = new Stack<>();
			String[] sarr = bf.readLine().split("");	
			check(sarr);
			
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean check(String[] sarr) {
		stack.add(sarr[0]);
		for(int i=1; i<sarr.length; i++) {
			if(sarr[i].equals(close)) {
				if(stack.isEmpty()) {
					sb.append("NO").append("\n");
					return false;
				}
				if(stack.peek().equals(open)){
					stack.pop();
				}
			}else if(sarr[i].equals(open)){
				stack.add(sarr[i]);
			}else {
				sb.append("NO").append("\n");
				return false;
			}
		}
		
		if(!stack.isEmpty()) {
			sb.append("NO").append("\n");
			return false;
		}
		sb.append("YES").append("\n");
		return true;
	}
}
