import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, r, c, l;
	static String[][] arr;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t=  Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			ans = 1;
			arr = new String[n][m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<m; j++) {
					arr[i][j] = st.nextToken();
				}
			}
			
			bfs();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static void bfs() {
		Queue<person> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		
		q.add(new person(r,c, 1));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			person poll = q.poll();
			int y = poll.y;
			int x = poll.x;
			int time = poll.time;
			String target = arr[y][x];
			
			if(time == l) break;
			
			for(int i=0; i<4; i++) {
				// 갈 수 있는 방향인지 확인
				if(i==0 && !("1247".contains(target))) continue;
				if(i==1 && !("1256".contains(target))) continue;
				if(i==2 && !("1367".contains(target))) continue;
				if(i==3 && !("1345".contains(target))) continue;
				
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(!outOfIdx(ny, nx)) continue;
				if(visited[ny][nx]) continue;
				String nt = arr[ny][nx];
				
				if(nt.equals("0")) continue;
				
				if(i==0 && "347".contains(nt)) continue;
				if(i==1 && "356".contains(nt)) continue;
				if(i==2 && "267".contains(nt)) continue;
				if(i==3 && "245".contains(nt)) continue;
				
				q.add(new person (ny, nx, time+1));
				visited[ny][nx] = true;
				ans++;
			}
		}
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<m) {
			return true;
		}
		return false;
	}
	
	static class person{
		int y, x, time;

		public person(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
}