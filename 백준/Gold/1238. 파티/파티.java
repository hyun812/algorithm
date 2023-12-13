import java.io.*;
import java.util.*;

public class Main {
	static int n, m, x;
	static ArrayList<Node>[] list1, list2;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 학생 수
		m = Integer.parseInt(st.nextToken()); // 단방향 도로의 수
		x = Integer.parseInt(st.nextToken()); // 파티가 열리는 마을 번호

		answer = 0;

		// list 초기화
		list1 = new ArrayList[n + 1];
		list2 = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list1[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}
		
		// 입력 받기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			list1[from].add(new Node(to, time));
			list2[to].add(new Node(from, time));
		}
		
		int[] go = Dijkstra(list1, x); // 다른 모든 마을 -> x마을
		int[] back = Dijkstra(list2, x); // x마을 -> 다른 모든 마을
		
		for(int i=1; i<=n; i++) {
			int temp = go[i]+back[i];
			answer = Math.max(answer, temp);
		}
		
		
		System.out.println(answer);
	}

	// 각각의 마을에 한 명의 한생이 살고 있음
	private static int[] Dijkstra(ArrayList<Node>[] list, int start) {
		Queue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);		
		
		dist[start] = 0;
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(visited[poll.to]) continue;
			visited[poll.to] = true;
			
			for(Node next : list[poll.to]) {
				if(dist[poll.to] + next.time < dist[next.to]) {
					dist[next.to] = dist[poll.to] + next.time;
					q.offer(new Node(next.to, dist[next.to]));
				}
				
			}
		}
		
		return dist;
	}

	static class Node implements Comparable<Node> {
		int to, time; // 목적치, 가중치

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