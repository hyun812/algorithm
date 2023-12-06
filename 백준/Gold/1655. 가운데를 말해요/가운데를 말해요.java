import java.io.*;
import java.util.*;

public class Main {
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(bf.readLine());
		Queue<Integer> leftQ = new PriorityQueue<>((a, b) -> {
			return b - a;
		}); // 큰값 가져옴 (내림차순)
		Queue<Integer> rightQ = new PriorityQueue<>(); // 작은값 가져옴 (오름차순)
		

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(bf.readLine());

			if (rightQ.size() == leftQ.size())
				leftQ.offer(num);
			else
				rightQ.offer(num);

			if (!rightQ.isEmpty() && !leftQ.isEmpty()) {
				if (leftQ.peek() > rightQ.peek()) {
					int temp = rightQ.poll();
					rightQ.offer(leftQ.poll());
					leftQ.offer(temp);
				}
			}
			sb.append(leftQ.peek()).append("\n");
		}

		System.out.println(sb.toString());
	}
}