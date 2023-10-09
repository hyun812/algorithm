import java.io.*;
import java.util.*;

public class Solution {
	static int n, k;
	static boolean[] visited;
	static ArrayList<int[]> list;
	static int endY, endX;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(bf.readLine()); // 고객 수
			
			list = new ArrayList<>();
			visited = new boolean[n];
			ans = Integer.MAX_VALUE;
			
			st = new StringTokenizer(bf.readLine());
			
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			
			endY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<n; i++) {
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				list.add(new int[] {y, x});
			}
			
			dfs(startY, startX, 0, 0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void dfs(int y, int x, int dis, int cnt) {
		if(cnt == n) {
			// 전부다 돌았으면
			ans = Math.min(ans, dis+getDis(y, x, endY, endX));
			return;
		}
		
		for(int i=0; i<list.size(); i++) {
			int[] li = list.get(i);
			int ny = li[0];
			int nx = li[1];
			if(visited[i]) continue;
			int d = getDis(y, x, ny, nx);
			visited[i] = true;
			dfs(ny, nx, dis+d, cnt+1);
			visited[i] = false;
		}
	}
	
	private static int getDis(int y, int x, int ny, int nx) {
		return Math.abs(y-ny) + Math.abs(x-nx);
	}
}