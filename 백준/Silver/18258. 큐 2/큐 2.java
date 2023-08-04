
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
	
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			String s = st.nextToken();
			
			switch(s) {
			case "push" :
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
				break;
			case "pop" :
				if(deque.peek() == null) sb.append("-1").append("\n");
				else {
					sb.append(deque.pollFirst()).append("\n");	
				}
				break;
			case "size" :
				sb.append(deque.size()).append("\n");
				break;
			case "empty" :
				if(deque.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				break;
			case "front" :
				if(deque.peek() == null) sb.append("-1").append("\n");
				else {
					sb.append(deque.peekFirst()).append("\n");	
				}
				break;
			case "back" :
				if(deque.peek() == null) sb.append("-1").append("\n");
				else{
					sb.append(deque.peekLast()).append("\n");
				}
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
