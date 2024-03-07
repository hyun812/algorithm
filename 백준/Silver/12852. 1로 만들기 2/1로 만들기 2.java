import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] dp, before;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());

		dp = new int[n + 1];
		before = new int[n + 1];

		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			before[i] = i - 1;
			
			if (i % 2 == 0 && dp[i] > dp[i/2]+1) {
				dp[i] = dp[i / 2] + 1;
				before[i] = i/2;
			}
			if (i % 3 == 0 && dp[i] > dp[i/3]+1) {
				dp[i] = dp[i / 3] + 1;
				before[i] = i/3;
			}  
		}
		
		sb.append(dp[n]).append("\n");
		
		while(n > 0){
			sb.append(n).append(" ");
            n = before[n];
        }

		System.out.println(sb.toString());
	}
}

/*
 * 0 1 1 2 3 2 3 3 2 3
 * 
 */