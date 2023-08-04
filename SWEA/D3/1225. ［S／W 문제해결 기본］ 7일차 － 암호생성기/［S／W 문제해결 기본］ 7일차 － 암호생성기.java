
import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i=0; i<10; i++) {
			String tc = bf.readLine();	
			st = new StringTokenizer(bf.readLine());
			Queue<Integer> queue = new LinkedList<>();
			for(int j=0; j<8; j++) {
				int a = Integer.parseInt(st.nextToken());
				queue.add(a);
			}
			sb.append("#").append(tc).append(" ");
			check(queue);
		}	
		
		System.out.println(sb.toString());
		
	}
	
	public static void check(Queue<Integer> queue) {
		int cnt = 1;
		
		while(true) {
			if(cnt == 6) cnt =1;
			int front = queue.poll();
			
			if(front - cnt <= 0) {
				queue.add(0);
				break;
			}
			
			queue.add(front-cnt);
			cnt++;
		}
		
		for(Integer i : queue) {
			sb.append(i).append(" ");
		}
		
		sb.append("\n");
		return;
	}
}
