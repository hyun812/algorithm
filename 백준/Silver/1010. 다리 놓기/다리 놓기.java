import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int[][] dp = new int[30][30];
			
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// m 개중에 n개 뽑기
			
			for(int i=0; i<=m; i++) { // 초기화
				dp[i][i] = 1;
				dp[i][0] = 1;
			}
			
			for(int i=2; i<=m; i++) {
				for(int j=1; j<=n; j++) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
//			for(int i=0; i<=m; i++) {
//				System.out.println(Arrays.toString(dp[i]));		
//				
//			}
			
			System.out.println(dp[m][n]);
			
		}
		
	}
	
	
}

