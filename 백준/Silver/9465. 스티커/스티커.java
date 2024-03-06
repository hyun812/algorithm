import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp, arr;

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(bf.readLine());

			dp = new int[2][n];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (n > 1) {
				dp[0][1] = dp[0][1] + dp[1][0];
				dp[1][1] = dp[1][1] + dp[0][0];
				
				for (int j = 2; j < n; j++) {
					dp[0][j] = Math.max(dp[0][j - 2] + dp[0][j],
							Math.max(dp[1][j - 2] + dp[0][j], dp[1][j - 1] + dp[0][j]));

					dp[1][j] = Math.max(dp[0][j - 2] + dp[1][j],
							Math.max(dp[1][j - 2] + dp[1][j], dp[0][j - 1] + dp[1][j]));
				}

			}

			
			sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");

		}
		System.out.println(sb.toString());

	}
}