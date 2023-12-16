import java.io.*;
import java.util.*;

public class Main {
	static int n, m, r;
	static int[] arr;
	static ArrayList<Node>[] list;

	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 지역의 개수
		m = Integer.parseInt(st.nextToken()); // 수색 범위
		r = Integer.parseInt(st.nextToken()); // 길의 개수

		answer = 0;
		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		arr = new int[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			// 양방향
			list[from].add(new Node(to, len));
			list[to].add(new Node(from, len));
		}
		
		for(int i=1; i<=n; i++) {
			dijkstra(i);
		}
		
		System.out.println(answer);
	}

	private static void dijkstra(int start) {
		Queue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(visited[poll.to]) continue;
			
			visited[poll.to] = true;
			
			for(Node n : list[poll.to]) {
				if(dist[poll.to] + n.len < dist[n.to]) {
					dist[n.to] = dist[poll.to] + n.len;
					q.add(new Node(n.to, dist[n.to]));
				}
			}
		}
//		System.out.println(Arrays.toString(dist));
		
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(dist[i] <= m) {
				cnt += arr[i];
			}
		}
		
		answer = Math.max(answer, cnt);
	}

	static class Node implements Comparable<Node> {
		int to, len;

		public Node(int to, int len) {
			super();
			this.to = to;
			this.len = len;
		}

		public int compareTo(Node o) {
			return this.len - o.len;
		}

	}
}