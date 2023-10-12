import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int n = Integer.parseInt(bf.readLine());
		
		int[][] arr = new int[n+1][n+1];
		long[][][] dp = new long[n+1][n+1][3]; // 0 : 가로 , 1 : 세로, 2 : 대각선
		
		
		// 입력 받기
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j] == 1) continue; // 빈칸이면 continue
				
				// i,j 위치에 d 방향으로 파이프가 도달할 수 있는 방법의 경우의 수
				dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
				dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
				
				if(arr[i-1][j] == 0 && arr[i][j-1] == 0) { // 해당 위치에 파이프가 놓여져 있지 않으면
					dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];	
				}
			}
		}
		
		long ans = dp[n][n][0]+dp[n][n][1]+dp[n][n][2];
		System.out.println(ans);
		
		
	}
}