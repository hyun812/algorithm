import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static long[][] dp;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());

		arr = new int[n][n];
		dp = new long[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = arr[i][j];

				if (num == 0)
					break;

				for (int k = 0; k < 2; k++) {
					int ny = i + (dy[k] * num);
					int nx = j + (dx[k] * num);

					if (!outOfIdx(ny, nx))
						continue;
					dp[ny][nx] += dp[i][j];
				}
			}
		}

		System.out.println(dp[n - 1][n - 1]);
	}

	static int[] dy = { 1, 0 };
	static int[] dx = { 0, 1 };

	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
			return true;
		}
		return false;
	}
}