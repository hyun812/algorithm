import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int size = Math.max(n+1, 3);
		int[] dp = new int[size];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1]+dp[i-2]) %10007;
		}
		
		System.out.println(dp[n]);
				
	}
	
}
