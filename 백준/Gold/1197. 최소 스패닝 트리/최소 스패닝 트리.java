import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static ArrayList<Node>[] list;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 정점의 개수
		m = Integer.parseInt(st.nextToken()); // 간선의 개수

		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		prim(1);
		
		System.out.println(answer);
	}
	
	private static void prim(int start) {
		Queue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			int no = poll.no;
			int w = poll.w;
			
			if(visited[no]) continue;
			visited[no] = true;
			answer += w;
			
			for(Node node : list[no]) {
				if(visited[node.no]) continue;
				
				q.add(new Node(node.no, node.w));
			}
		}
	}

	static class Node implements Comparable<Node> {
		int no, w;

		public Node(int no, int w) {
			super();
			this.no = no;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}
}