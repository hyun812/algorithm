import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		
		int[][] dp = new int[10001][4]; // [정수][끝나는 숫자]
		dp[1][1] = 1; // 1
		dp[2][1] = 1; // 1 1
		dp[2][2] = 1; // 2
		dp[3][1] = 1; // 1 1 1
		dp[3][2] = 1; // 1 2
		dp[3][3] = 1; // 3
	
		// 4를 만든다 치면
		// 3애들에서 1을 더한다
		// 2애들에서 2를 더한다 ( 1,1  ,  2 )
		// 1에들에서 3을 더한다 ( 1,1,1  ,  1,2   ,  3 )
		for(int i=4; i<=10000; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(bf.readLine());
			
			int answer = 0;
			for(int j=1; j<=3; j++) {
				answer += dp[n][j];
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}