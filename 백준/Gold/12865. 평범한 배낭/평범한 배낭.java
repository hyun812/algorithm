import java.io.*;
import java.util.*;

public class Main {
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] wArr = new int[n + 1];
		int[] vArr = new int[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			wArr[i] = Integer.parseInt(st.nextToken());
			vArr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			int w = wArr[i];
			int v = vArr[i];
			
			for (int j = k; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j - w] + v);
			}
		}
		System.out.println(dp[k]);
		
	}
}