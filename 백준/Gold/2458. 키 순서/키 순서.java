import java.util.*;
import java.io.*;

public class Main {
	static int m, n;
	static int[][] arr;
	static int tcnt, scnt;
	static int ans;

	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken()); // 정점의 수
        m = Integer.parseInt(st.nextToken()); // 간선 의 수
        arr = new int[n+1][n+1];
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(bf.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	arr[from][to] = 1;
        }
        
        for(int i=1; i<=n; i++) {
        	boolean[] visited1 = new boolean[n+1];
        	boolean[] visited2 = new boolean[n+1];
        	tcnt = scnt = 0;
        	tdfs(i, visited1);
        	sdfs(i, visited2);
        	
        	if(tcnt + scnt == n-1) {
        		ans++;
        	}
        }
        
        System.out.println(ans);
	}
	
	// 위로 탐색
	private static void tdfs(int cur, boolean[] visited) {
		for(int i=1; i<=n; i++) {
			if(visited[i]) continue;
			if(arr[cur][i] == 1) {
				visited[i] = true;
				tcnt++;
				tdfs(i, visited);
			}
		}
	}
	
	private static void sdfs(int cur, boolean[] visited) {
		for(int i=1; i<=n; i++) {
			if(visited[i]) continue;
			if(arr[i][cur] == 1) {
				visited[i] = true;
				scnt++;
				sdfs(i, visited);
			}
		}
	}
	// 밑으로 탐색
}