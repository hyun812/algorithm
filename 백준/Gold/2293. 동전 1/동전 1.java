import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		int[] dp = new int[k+1];
		dp[0] = 1;
		
		for(int coin : arr) {
			for(int i=coin; i<=k; i++) {
				dp[i] += dp[i-coin];
			}
		}
		
		System.out.println(dp[k]);
	}
}