import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] Aarr, Barr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());

		long[][] dp = new long[n + 1][2];
		dp[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
			
		}

		System.out.println(dp[n][0]+dp[n][1]);

	}
}