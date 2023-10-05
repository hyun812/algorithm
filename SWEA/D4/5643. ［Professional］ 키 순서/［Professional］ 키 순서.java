import java.io.*;
import java.util.*;

public class Solution {
	static int n,m;
	static int[][] adj;
	static int tcnt, scnt;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine().trim());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(bf.readLine().trim());
			m = Integer.parseInt(bf.readLine().trim());
			
			adj = new int[n+1][n+1];
			ans = 0;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
			}
			
			for(int i=1; i<=n; i++) {
				boolean[] visited = new boolean[n+1];
				
				tcnt = 0;
				scnt = 0;
				tdfs(i, visited);
				sdfs(i, visited);
				
				if(tcnt + scnt == n-1) {
					ans++;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
//			for(int i=0; i<=n; i++) {
//				System.out.println(Arrays.toString(adj[i]));	
//			}
//			System.out.println();
		}
	}
	
	private static void tdfs(int cur, boolean[] visited) {
		for(int i=1; i<=n; i++) {
			if(adj[cur][i] == 1 && !visited[i]) { // 자신보다 크면서 방문하지 않았으면
				visited[i] = true;
				tcnt++;
				tdfs(i, visited);
			}
		}
	}
	
	private static void sdfs(int cur, boolean[] visited) {
		for(int i=1; i<=n; i++) {
			if(adj[i][cur] == 1 && !visited[i]) { // 자신보다 크면서 방문하지 않았으면
				visited[i] = true;
				scnt++;
				sdfs(i, visited);
			}
		}
	}
}