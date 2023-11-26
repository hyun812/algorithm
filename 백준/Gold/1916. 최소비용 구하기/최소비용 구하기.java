import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static ArrayList<Node>[] list;
	static int[] dist;
	static int start, end;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine()); // 도시의 개수
		m = Integer.parseInt(bf.readLine()); // 버스의 개수
		
		list = new ArrayList[n+1]; // 리스트 초기화
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, cost));
		}
		
		dist = new int[n+1]; // 최소 거리를 저장할 배열
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		st = new StringTokenizer(bf.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		System.out.println(dist[end]);
	}
	
	private static void dijkstra() {
		Queue<Node> q = new PriorityQueue<>();
		boolean[] visited= new boolean[n+1];
		
		q.add(new Node(start, 0));
		dist[start] = 0; // 시작 노드 초기화
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.v == end) { // 목표정점이 구해졌다면
				return;
			}
			
			if(dist[poll.v] < poll.w) {
				continue;
			}
			
			for(int i=0; i<list[poll.v].size(); i++) { // 해당 노드에서 갈 수 있는 곳 탐색
				Node n = list[poll.v].get(i);
				
				if(visited[n.v]) continue; // 이미 방문한 곳이면
				
				if(dist[n.v] > dist[poll.v] + n.w) {
					dist[n.v] = dist[poll.v] + n.w;
					q.offer(new Node(n.v, dist[n.v]));
				}
				
			}
		}
	}
	static class Node implements Comparable<Node>{
		int v, w; // 목적지, 가중치
		
		@Override
		public String toString() {
			return "node [v=" + v + ", w=" + w + "]";
		}

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}
}