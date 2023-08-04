
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();
			
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int result = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(bf.readLine());
			if(num !=0) {
				stack.add(num);
			}else {
				stack.pop();
			}
		}
		
		for(Integer i : stack) {
			result += i;
		}
		
		System.out.println(result);
	}
}
