
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();
	static Stack<Integer> stack = new Stack<>();
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			queue.add(a);
		}
		check();
	}
	
	private static void check() {
		
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			
			if(cnt == queue.peek()) {
				queue.poll();
				cnt++;
			}else {
				if(!stack.isEmpty() && stack.peek() == cnt) {
					stack.pop();
					cnt++;
				}else {
					stack.add(queue.poll());	
				}
			}
		}
		
		while(!stack.isEmpty()) {
			int top = stack.peek();
			
			if(cnt == top) {
				stack.pop();
				cnt++;
			}else {
				System.out.println("Sad");
				return;
			}
		}
		
		System.out.println("Nice");
		return;
	}
}
