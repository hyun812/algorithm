import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] parent;
	static ArrayList<Integer>[] list;

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());

		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			String s = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (s.equals("E")) { // 원수라면
				list[a].add(b);
				list[b].add(a);
			} else if (s.equals("F")) { // 친구라면
				union(a, b);
			}
		}

//		System.out.println(Arrays.toString(parent));
		for (int i = 1; i <= n; i++) {
			bfs(i);
		}
		
		for(int i=1; i<=n; i++) {
			if(i==parent[i]) {
				answer++;
			}
		}
//		System.out.println(Arrays.toString(parent));
		System.out.println(answer);
	}

	private static void bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		q.add(new int[] { start, 0 });
		visited[start] = true;

		while (!q.isEmpty()) {
			int[] poll = q.poll();

			int pos = poll[0];
			int len = poll[1];
			
			if(len == 2) {
				union(start, pos);
			}
			for (int i = 0; i < list[pos].size(); i++) {
				int target = list[pos].get(i);

				if (visited[target])
					continue;
				q.add(new int[] { target, len + 1 });
				visited[target] = true;
			}
		}

	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			parent[pa] = pb;
		}

	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}

}