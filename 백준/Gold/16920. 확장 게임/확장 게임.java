import java.io.*;
import java.util.*;

public class Main {
	static int n, m, s;
	static String[][] arr;
	static Queue<player>[] q;
	static int[] rangeArr;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new String[n][m];
		ans = new int[s+1];
		q = new LinkedList[s+1];
		
		for(int i=1; i<=s; i++) {
			q[i] = new LinkedList<>();	
		}
		
		
		rangeArr = new int[s+1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1; i<=s; i++) {
			rangeArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			String[] s = bf.readLine().split("");
			for(int j=0; j<m; j++) {
				arr[i][j] = s[j];
				if(arr[i][j].equals(".")) continue;
				if(arr[i][j].equals("#")) continue;
				
				int target = Integer.parseInt(arr[i][j]);
				ans[target]++;
				q[target].add(new player(i, j));
			}
		}
		
		int player = 1;
		int round = 0;
		
		while(true) {
			int range = rangeArr[player];
			int cnt = bfs(q[player], range, player);
			
			ans[player] += cnt;
			round += cnt;
			
			player++;
			if(player == s+1) {
				if(round == 0) break;
				round = 0;
				player = 1;
			}
		}
		
		for(int i=1; i<=s; i++) {
			System.out.print(ans[i] + " ");	
		}
		
	}
	
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static int bfs(Queue<player> q, int range, int player ) {
		
		int cnt = 0;
		int r = 1;
		while (!q.isEmpty()) {
			
			int size = q.size();
			
			for(int k=0; k<size; k++) {
				player p = q.poll();
				int y = p.y;
				int x = p.x;
				
				for(int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					if(!outOfIdx(ny, nx)) continue;
					if(!arr[ny][nx].equals(".")) continue;

					cnt++;
					q.add(new player(ny, nx));
					arr[ny][nx] = Integer.toString(player);
				}
			}
			r++;
			if(r > range) {
				break;
			}
			
		}
		
		return cnt;
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<m) {
			return true;
		}
		return false;
	}
	
	
	static class player{
		int y, x;

		public player(int y, int x) {
			super();
			
			this.y = y;
			this.x = x;
		}
	}
}