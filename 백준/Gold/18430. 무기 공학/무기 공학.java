import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		doit(0, 0, 0);

		System.out.println(answer);
	}

	private static void doit(int y, int x, int sum) {
		if (x == m) {
			doit(y + 1, 0, sum);
			return;
		}

		if (y == n && x == 0) {
			answer = Math.max(answer, sum);
			return;
		}

			
		if(!visited[y][x]) {
			if (outOfIdx(y, x - 1) && outOfIdx(y + 1, x) && !visited[y][x - 1] && !visited[y + 1][x]) {
				visited[y][x] = true;
				visited[y][x - 1] = true;
				visited[y + 1][x] = true;
				doit(y, x + 1, sum + 2 * arr[y][x] + arr[y][x - 1] + arr[y + 1][x]);
				visited[y][x] = false;
				visited[y][x - 1] = false;
				visited[y + 1][x] = false;
			}
			if (outOfIdx(y - 1, x) && outOfIdx(y, x - 1) && !visited[y - 1][x] && !visited[y][x - 1]) {
				visited[y][x] = true;
				visited[y - 1][x] = true;
				visited[y][x - 1] = true;
				doit(y, x + 1, sum + 2 * arr[y][x] + arr[y - 1][x] + arr[y][x - 1]);
				visited[y][x] = false;
				visited[y - 1][x] = false;
				visited[y][x - 1] = false;
			}
			if (outOfIdx(y - 1, x) && outOfIdx(y, x + 1) && !visited[y - 1][x] && !visited[y][x + 1]) {
				visited[y][x] = true;
				visited[y - 1][x] = true;
				visited[y][x + 1] = true;
				doit(y, x + 1, sum + 2 * arr[y][x] + arr[y - 1][x] + arr[y][x + 1]);
				visited[y][x] = false;
				visited[y - 1][x] = false;
				visited[y][x + 1] = false;
			}
			if (outOfIdx(y + 1, x) && outOfIdx(y, x + 1) && !visited[y + 1][x] && !visited[y][x + 1]) {
				visited[y][x] = true;
				visited[y + 1][x] = true;
				visited[y][x + 1] = true;
				doit(y, x + 1, sum + 2 * arr[y][x] + arr[y + 1][x] + arr[y][x + 1]);
				visited[y][x] = false;
				visited[y + 1][x] = false;
				visited[y][x + 1] = false;
			}	
		}
		doit(y, x + 1, sum);
	}

	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
			return true;
		}
		return false;
	}

}