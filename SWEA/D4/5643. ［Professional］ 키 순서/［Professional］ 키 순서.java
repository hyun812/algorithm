import java.io.*;
import java.util.*;

public class Solution {
	static int n, m;
	static int[][] adj, radj;
	static int ans;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(bf.readLine()); // 학생 수
			m = Integer.parseInt(bf.readLine()); // 관계 수
			
			adj = new int[n+1][n+1]; // 인접행렬
			radj = new int[n+1][n+1]; // 인접행렬
			cnt = 0;
			ans = 0;
			for(int i=0; i<m; i++) { // 관계정보 : 학생번호 1번부터 시작
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1; // from키 < to키
				radj[to][from] = 1; // to키 < from키
			}
			
			for(int i=1; i<=n; i++) { // 모든 학생 기준으로 자신보다 큰 학생, 작은 학생으로 각각 DFS 탐색
				cnt = 0;
				boolean[] visited = new boolean[n+1];
				dfs(i, adj, visited);
				dfs(i, radj, visited);
				
				if(cnt == n-1) {
					ans++;
				}
			}
			System.out.println("#"+tc+" " + ans);
		}
	}
	
	private static void dfs(int cur, int[][] adj, boolean[] visited) {
		visited[cur] = true;
		for(int i=1; i<=n; i++) {
			if(adj[cur][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}
		}
	}
}