import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			String[] s = bf.readLine().split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}

		bfs();
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	private static void bfs() {
		Queue<Node> q = new PriorityQueue<>();
		boolean[][] visited = new boolean[m][n];

		q.add(new Node(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Node poll = q.poll();
			int y = poll.y;
			int x = poll.x;
			int block = poll.block;

			if (y == m - 1 && x == n - 1) {
				System.out.println(block);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || ny >= m || nx >= n)
					continue;
				if (visited[ny][nx])
					continue;

				if (arr[ny][nx] == 0) {
					q.offer(new Node(ny, nx, block));
				} else {
					q.offer(new Node(ny, nx, block + 1));
				}
				visited[ny][nx] = true;
			}
		}
	}

	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
			return true;
		}
		return false;
	}

	static class Node implements Comparable<Node> {
		int y, x, block;

		public Node(int y, int x, int block) {
			super();
			this.y = y;
			this.x = x;
			this.block = block;
		}

		@Override
		public int compareTo(Node o) {
			return this.block - o.block;
		}
	}
}