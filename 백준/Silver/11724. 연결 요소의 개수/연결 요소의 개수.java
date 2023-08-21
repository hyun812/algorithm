import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int n, m;
	static int ans =0;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1]; 
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++){
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
			bfs(1);
			
			System.out.println(ans);	
		
	}
	
	private static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			
			for(int i=1; i<arr[poll].length; i++) {
				if(!visited[i] && arr[poll][i]==1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		ans++;
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				bfs(i);
			}
		}
	}
}
