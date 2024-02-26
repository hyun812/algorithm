import java.io.*;
import java.util.*;

public class Main {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		long[][] dp = new long[n + 1][10];

		for (int i = 0; i <= 9; i++) {
			dp[0][i] = 1;
		}

		// 마지막 숫자의 개수만 센다
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {

				for (int k = 9; k >= j; k--) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= 10007;
				}
			}
		}

		System.out.println(dp[n][0]);
	}
}