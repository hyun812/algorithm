import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[][] arr;
	static int startY, startX;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bf.readLine());

			n = Integer.parseInt(st.nextToken());

			arr = new int[n][n];
			ans = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[] visited = new boolean[101]; // 같은 디저트를 먹었는지 확인하기 위한 배열
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					startY = i;
					startX = j;

					int target = arr[i][j];
					visited[target] = true;
					dfs(i, j, 0, 1, visited);
					visited[target] = false;
				}
			}
			if (ans == Integer.MIN_VALUE) {
				ans = -1;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dy = { -1, -1, 1, 1 };
	static int[] dx = { -1, 1, 1, -1 };

	private static void dfs(int y, int x, int dis, int cnt, boolean[] visited) {

		// 사각형 모양을 만들기 위해
		for (int i = dis; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			// 다시 원점으로 돌아와야 함
			if (ny == startY && nx == startX && cnt > 2) {
				ans = Math.max(ans, cnt);
				return;
			}

			if (!outOfIdx(ny, nx))
				continue; // 범위 벗어나면

			int target = arr[ny][nx];
			if (visited[target])
				continue; // 이미 먹은 디저트라면

			visited[target] = true;
			dfs(ny, nx, i, cnt + 1, visited);
			visited[target] = false;
		}
	}

	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
			return true;
		}
		return false;
	}
}