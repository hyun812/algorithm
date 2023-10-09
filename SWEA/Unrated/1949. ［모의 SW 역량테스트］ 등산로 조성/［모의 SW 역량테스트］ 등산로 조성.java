import java.io.*;
import java.util.*;

public class Solution {
	static int n, k;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken()); // 크기
			k  = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이 , 딱 한곳을 정해서 최대 k깊이 만큼
			
			map = new int[n][n];
			visited = new boolean[n][n];
			ans = 0;
			
			int max = 0;
			
			// 입력 받기 + 최댓값 찾기
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			// 최대값이라면 dfs
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(max == map[i][j]) {
						visited[i][j] = true;
						dfs(i, j, 1, map[i][j], false);
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	private static void dfs(int y, int x, int dis, int h, boolean flag) {
		
		ans = Math.max(ans, dis);
		
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(!outOfIdx(ny, nx)) continue; // 범위를 벗어났으면
			if(visited[ny][nx]) continue; // 이미 방문했던 적이 있으면

			int nh = map[ny][nx];
			if(h <= nh) { // 높이가 큰 산을 만났으면
				if(flag) continue; // 이미 산을 깎은적이 있다면
				if(h <= nh-k) continue; // 최대 깊이만큼 깎아도 더크다면
				
				visited[ny][nx] = true;
				dfs(ny, nx, dis+1, h-1, true);
				visited[ny][nx] = false;
			}
			else{ // 나보다 높이가 작은 산을 만났으면
				visited[ny][nx] = true;
				dfs(ny, nx, dis+1, map[ny][nx], flag);
				visited[ny][nx] = false;
			}
			
		}
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<n) {
			return true;
		}
		return false;
	}
}