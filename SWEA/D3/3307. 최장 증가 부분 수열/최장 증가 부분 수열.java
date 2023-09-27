import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());

		for(int tc = 1; tc<=t; tc++) {
			n = Integer.parseInt(bf.readLine());
			
			arr = new int[n];
			dp = new int[n];
			int ans = 1;
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0] = 1;
			for(int i=1; i<n; i++) {
				dp[i] = 1;
				
				for(int j=i-1; j>=0; j--) {
					if(arr[i] > arr[j]) { // 나보다 작으면
						dp[i] = Math.max(dp[j]+1, dp[i]);
					}
				}
				ans = Math.max(ans, dp[i]);
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}