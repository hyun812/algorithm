import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		int[][] dp = new int[n][3];
		
		st = new StringTokenizer(bf.readLine());
		dp[0][0] = Integer.parseInt(st.nextToken());
		dp[0][1] = Integer.parseInt(st.nextToken());
		dp[0][2] = Integer.parseInt(st.nextToken());
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i-1][1]+r, dp[i-1][2]+r);
			dp[i][1] = Math.min(dp[i-1][0]+g, dp[i-1][2]+g);
			dp[i][2] = Math.min(dp[i-1][0]+b, dp[i-1][1]+b);
		}
		
		int ans = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
		System.out.println(ans);
	}
	
}

