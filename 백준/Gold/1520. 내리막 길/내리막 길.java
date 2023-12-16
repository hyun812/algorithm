import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
 			}
		}
		
		dp = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dp[i][j] = -1;
			}
		}
		
		dfs(0, 0);
//		for(int i=0; i<n; i++) {
//			System.out.println(Arrays.toString(dp[i]));	
//		}
//		
		System.out.println(dp[0][0]);
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static int dfs(int y, int x) {
		
		if(y == n-1 && x == m-1) {
			return 1;
		}
		
		if (dp[y][x] != -1) {
			return dp[y][x];
		}
		
		dp[y][x] = 0;
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
			if(arr[y][x] <= arr[ny][nx]) continue;
			
			dp[y][x] += dfs(ny, nx);
		}
		
		return dp[y][x];
	}
}