import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static String[][] arr;
	static ArrayList<int[]> coins;
	static boolean[][] visited;
	static Queue<coin> q;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new String[n][m];
		coins = new ArrayList<>();
		visited = new boolean[n * m + m][n * m + m];
		q = new ArrayDeque<>();
		answer = -1;

		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = s[j];

				if (arr[i][j].equals("o")) {
					coins.add(new int[] { i, j });
				}
			}
		}

		int y1, x1, y2, x2;

		y1 = coins.get(0)[0];
		x1 = coins.get(0)[1];
		y2 = coins.get(1)[0];
		x2 = coins.get(1)[1];

		q.add(new coin(y1, x1, y2, x2, 0));
		visited[y1 * m + x1][y2 * m + x2] = true;
		bfs();

		System.out.println(answer);
	}

	// 버튼 누르면 동전 같이 이동
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	private static void bfs() {

		while (!q.isEmpty()) {
			coin poll = q.poll();

			int y1 = poll.y1;
			int x1 = poll.x1;
			int y2 = poll.y2;
			int x2 = poll.x2;
			int count = poll.count;

			if (count >= 10)
				return;

			for (int i = 0; i < 4; i++) {
				int ny1 = y1 + dy[i];
				int nx1 = x1 + dx[i];

				int ny2 = y2 + dy[i];
				int nx2 = x2 + dx[i];

				int flag = 0;
				if (!outOfIdx(ny1, nx1)) {
					flag++;
				}
				if (!outOfIdx(ny2, nx2)) {
					flag++;
				}

				if (flag == 2) // 둘다 떨어졌음
					continue;
				else if (flag == 1) { // 조건을 만족
					answer = count + 1;
					return;
				}

				// 방문한 적이 있음
				if (visited[ny1 * m + nx1][ny2 * m + nx2])
					continue;

				// 벽이면 가만히 있기
				if (arr[ny1][nx1].equals("#")) {
					ny1 = y1;
					nx1 = x1;
				}
				if (arr[ny2][nx2].equals("#")) {
					ny2 = y2;
					nx2 = x2;
				}

				visited[ny1 * m + nx1][ny2 * m + nx2] = true;
				q.add(new coin(ny1, nx1, ny2, nx2, count + 1));
			}
		}

	}

	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
			return true;
		}
		return false;
	}

	static class coin {
		int y1, x1, y2, x2, count;

		public coin(int y1, int x1, int y2, int x2, int count) {
			super();
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
			this.count = count;
		}
	}
}