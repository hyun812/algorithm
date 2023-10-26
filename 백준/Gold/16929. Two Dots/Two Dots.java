import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static String[][] arr;
	static boolean[][] visited;
	static int startY, startX;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new String[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String[] s = bf.readLine().split("");
			for(int j=0; j<m; j++) {
				arr[i][j] = s[j];
			}
		}
		
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				startY = i;
				startX = j;
				
				visited[i][j] = true;
				dfs(i, j, 1);
				visited[i][j] = false;
			}
		}
		
		System.out.println("No");
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static void dfs(int y, int x, int depth) {
		
		String target = arr[y][x];

		for(int i=0; i<4; i++) {
			
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(startY==ny && startX==nx && depth+1 >= 4) {
				System.out.println("Yes");
				System.exit(0);
			}
			
			if(!outOfIdx(ny, nx)) continue;
			if(visited[ny][nx]) continue;
			if(!target.equals(arr[ny][nx])) continue;
			
			
			visited[ny][nx] = true;
			dfs(ny, nx, depth+1);
			visited[ny][nx] = false;
			
		}
		
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<m) {
			return true;
		}
		return false;
	}
	
	private static void print() {
		for(int j=0; j<n; j++) {
			System.out.println(Arrays.toString(visited[j]));
		}
		System.out.println();
	}
}