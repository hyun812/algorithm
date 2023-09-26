import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] arr;
	static int[][] copy;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int ans;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		q = new LinkedList<>();
		ans = Integer.MIN_VALUE;
		list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				if(a == 2) {
					list.add(new int[] {i, j});
				}
			}
		}
		dfs(0);
		
		System.out.println(ans);
	}
	
	private static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(cnt+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static void bfs() {
		visited = new boolean[n][m];
		for(int i=0; i<list.size(); i++) {
			q.add(new int[] {list.get(i)[0], list.get(i)[1]});
		}
		
		copyArr();
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			visited[y][x] = true;
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(!outOfIdx(ny, nx)) continue;
				if(visited[ny][nx]) continue;
				if(copy[ny][nx] == 0) {
					copy[ny][nx] = 2;
					visited[ny][nx] = true;
					q.add(new int[] {ny, nx});	
				}
			}
		}
		
		
		
		int cnt = countZero();
		ans = Math.max(cnt, ans);
	}
	
	private static int countZero() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	private static void copyArr() {
		copy = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}
	
	private static boolean outOfIdx(int y, int x) {
		if(y>=0 && y<n && x>=0 && x<m) {
			return true;
		}
		return false;
	}
}
