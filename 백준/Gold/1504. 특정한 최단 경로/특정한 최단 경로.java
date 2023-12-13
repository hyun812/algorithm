import java.io.*;
import java.util.*;

public class Main {
	static int n, e;
	static ArrayList<Node>[] list;

	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 정점의 개수
		e = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		answer = 0;
		
		list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(bf.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[to].add(new Node(from, cost));
			list[from].add(new Node(to, cost));
		}
		
		st = new StringTokenizer(bf.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, n);
		
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, n);
		
		if(res1 >= 200000000 && res2 >= 200000000) answer= -1;
		else answer = Math.min(res1, res2);
		
		System.out.println(answer);
		
	}

	private static int dijkstra(int start, int end) {
		Queue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, 200000000);
		
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			
			if(visited[poll.to]) continue;
			
			visited[poll.to] = true;
			
			for(Node next : list[poll.to]) {
				if(dist[poll.to] + next.cost < dist[next.to]) {
					dist[next.to] = dist[poll.to] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		return dist[end];
	}
	
	
	static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
}