import java.io.*;
import java.util.*;

public class Main {
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(bf.readLine());
		Queue<Integer> minQ = new PriorityQueue<>((a, b) -> {
			return a - b;
		}); // 작은값 가져옴 (오름차순)
		Queue<Integer> maxQ = new PriorityQueue<>((a, b) -> {
			return b - a; 
		}); // 큰값 가져옴 (내림차순)

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(bf.readLine());
			
			if(minQ.size() == maxQ.size()) maxQ.offer(num);
			else minQ.offer(num);
			
			if(!minQ.isEmpty() && !maxQ.isEmpty()) {
				if(minQ.peek() < maxQ.peek()) {
					int temp = minQ.poll();
					minQ.offer(maxQ.poll());
					maxQ.offer(temp);
				}
			}
			sb.append(maxQ.peek()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}