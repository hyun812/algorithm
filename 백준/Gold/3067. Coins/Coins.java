import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine()); // 동전의 가지수
			
			arr = new int[n];
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			m = Integer.parseInt(bf.readLine());
			
			int[] dp = new int[m+1];
			dp[0] = 1;
			
			for(int coin : arr) {
				for(int i=coin; i<=m; i++) {
					dp[i] += dp[i-coin]; 
				}
			}
			sb.append(dp[m]).append("\n");
		}
		System.out.println(sb.toString());
	}
}