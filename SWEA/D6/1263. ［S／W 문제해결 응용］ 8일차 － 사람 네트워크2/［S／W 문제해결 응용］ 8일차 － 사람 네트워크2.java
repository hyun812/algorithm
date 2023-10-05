import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[][] arr;
	static int[] visited;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken()); // 크기
			arr = new int[n][n];
			ans = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<n; i++) {
				bfs(i);	
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new int[n];
		q.add(start);
		int temp = 0;
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int i=0; i<n; i++) {
				if(start == i) continue;
				if(arr[poll][i] == 0) continue;
				if(visited[i] != 0) continue;
				
				q.add(i);
				visited[i] = visited[poll]+1;
				temp += visited[i];
			}
		}
		ans = Math.min(ans, temp);
	}
}