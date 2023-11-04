import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[][] arr;
	static boolean[] desert;
	static boolean[][] visited;
	static int ans;
	static int startY, startX;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t=  Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			ans = -1;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			desert = new boolean[101];
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					startY = i;
					startX = j;
					
					desert[arr[i][j]]= true;
					visited[i][j] = true;
					dfs(i, j, 1, 0);
					desert[arr[i][j]]= false;
					visited[i][j] = false;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int[] dy = {-1, 1, 1, -1};
	static int[] dx = {1, 1, -1, -1};
	
	private static void dfs(int y, int x, int count, int preD) {
		
		for(int i=preD; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(!outOfIdx(ny, nx)) continue;
			
			if(ny == startY && nx == startX && count > 2) {
				ans = Math.max(ans, count);
				return;
			}
			
			if(visited[ny][nx]) continue; // 방문한 적이 있다면
			if(desert[arr[ny][nx]]) continue; // 이미 같은 종류를 먹었으면
			
			desert[arr[ny][nx]] = true;
			visited[ny][nx] = true;
			dfs(ny, nx, count+1, i);
			desert[arr[ny][nx]] = false;
			visited[ny][nx] = false;
		}
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<n) {
			return true;
		}
		return false;
	}
}