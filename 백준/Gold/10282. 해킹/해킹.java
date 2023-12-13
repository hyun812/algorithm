import java.io.*;
import java.util.*;

public class Main {
	static int n, d, c;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			list = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				list[to].add(new Node(from, time));
			}
			
			int[] arr = dijkstra(c);
//			System.out.println(Arrays.toString(arr));
			int cnt = 0;
			int maxTime = 0;
			for(int i=1; i<=n; i++) {
				if(arr[i] != Integer.MAX_VALUE) {
					cnt++;
					maxTime = Math.max(maxTime, arr[i]);
				}
			}
			sb.append(cnt).append(" ").append(maxTime).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int[] dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			
			if(visited[poll.to]) continue;
			visited[poll.to] = true;
			
			for(Node next : list[poll.to]) {
				if(dist[poll.to] + next.time < dist[next.to]) {
					dist[next.to] = dist[poll.to] + next.time;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		return dist;
	}

	static class Node implements Comparable<Node> {
		int to, time;

		public Node(int to, int time) {
			super();
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}

	}
}