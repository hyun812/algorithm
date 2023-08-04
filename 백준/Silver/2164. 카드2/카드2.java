
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0; i<n; i++) {
			queue.add(i+1);
		}
		int result = 0;
		while(true) {
			int front = queue.poll();
			
			if(queue.size() == 0) {
				result = front;
				break;
			}
			if(queue.size() == 1) {
				result = queue.peek();
				break;
			}
			
			int next = queue.poll();
			queue.add(next);
		}
		
		System.out.println(result);
	}
}
