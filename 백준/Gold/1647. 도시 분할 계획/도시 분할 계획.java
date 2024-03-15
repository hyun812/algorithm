import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	static int max;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 집의 개수
		m = Integer.parseInt(st.nextToken()); // 길의 개수

		visited = new boolean[n + 1];
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
		System.out.println(answer-max);
	}

	private static void prim(int start) {

		Queue<Node> pq = new PriorityQueue();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			int no = poll.no;
			int w = poll.w;

			if (visited[no])
				continue;

			visited[no] = true;
			answer += w;
			max = Math.max(max, w);

			for (Node n : list[no]) {
				if (!visited[n.no]) {
					pq.add(n);
				}
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

		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
}