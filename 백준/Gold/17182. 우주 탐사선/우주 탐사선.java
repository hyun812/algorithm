import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[][] arr;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 행성의 개수
		k = Integer.parseInt(st.nextToken()); // 행성의 위치

		arr = new int[n][n];
		visited = new boolean[n];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < n; k++) { // 경유지
			for (int i = 0; i < n; i++) { // 출발정점
				for (int j = 0; j < n; j++) { // 도착정점
					if (i == j)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		dfs(k, 0, 0);
		System.out.println(answer);
	}

	private static void dfs(int pos, int cnt, int time) {
		if (answer <= time)
			return;
		if (cnt == n) {
			answer = Math.min(answer, time);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			dfs(i, cnt + 1, time + arr[pos][i]);
			visited[i] = false;
		}
	}
}