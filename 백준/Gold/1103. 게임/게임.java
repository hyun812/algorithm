import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr;
	static boolean flag;
	static boolean[][] visited;
	static int[][] dp;

	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		dp = new int[n][m];
		flag = true;
		
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split("");
			for (int j = 0; j < m; j++) {
				if (s[j].equals("H"))
					continue;

				arr[i][j] = Integer.parseInt(s[j]);

			}
		}
		
		visited[0][0] = true;
		dfs(0,0,1);
		
		if (flag) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}

	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	private static void dfs(int y, int x ,int count) {
		dp[y][x] = count;
		if(answer < count) {
			answer = count;
		}
		
		int range = arr[y][x];
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i]*range;
			int nx = x + dx[i]*range;
			
			if(!outOfIdx(ny, nx)) continue; // 범위 벗어난 경우
			if(arr[ny][nx] == 0) continue; // 구멍인 경우
			if(dp[ny][nx] > count) {
				continue;
			};
			if(visited[ny][nx]) {
				flag =false;
				return;
			}
			
			visited[ny][nx] = true;
			dfs(ny, nx, count+1);
			visited[ny][nx] = false;
		}
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
			return true;
		}
		return false;
	}

}