import java.util.*;
import java.io.*;

public class Main {
	static int w, h;
	static String[][] arr;
	static int startY, startX;
	static Queue<fire> q;
	static boolean[][] visited;
	static String ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(bf.readLine());
		
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(bf.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			arr = new String[h][w];
			visited = new boolean[h][w];
			ans = "IMPOSSIBLE";
			q = new LinkedList<>();
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(bf.readLine());
				String s = st.nextToken();
				arr[i] = s.split("");
				for(int j=0; j<w; j++) {
					if(arr[i][j].equals(".")) continue;
					
					if(arr[i][j].equals("*")) { // 불이면 큐에 추가
						q.add(new fire(i, j, 0, true));
						visited[i][j] = true;
					}else if(arr[i][j].equals("@")) { // 상근이의 시작 위치
						startY = i;
						startX = j;
					}
				}
			}
			
			// 이제 불이 붙으려는 칸에는 상근이가 갈수 없으므로
			// 큐에 불을 모두 추가한 후 상근이 추가
			q.add(new fire(startY, startX, 0, false));
			
			bfs();
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	private static void bfs() {
		
		while(!q.isEmpty()) {
			fire f = q.poll();
			int y = f.y;
			int x = f.x;
			int time = f.time;
			boolean type = f.type;
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(!escape(ny, nx)) {
					if(type) { // 불이면 continue
						continue;
					}else { // 상근이면 탈출
						ans = Integer.toString(time+1);
						return;
					}
				}
				if(visited[ny][nx]) continue;
				if(arr[ny][nx].equals(".")) { // 빈공간이면
					arr[ny][nx] = arr[y][x];
					q.add(new fire(ny,nx,time+1, f.type));
					visited[ny][nx] = true;
					if(!type) arr[y][x] = ".";	
				}
			}
		}
	}
	
	private static boolean escape(int ny, int nx) { // false면 탈출
		if(ny>=0 && ny<h && nx>=0 && nx<w) {
			return true;
		}
		return false;
	}
	
	
	static class fire {
		int y, x, time;
		boolean type;
		
		public fire(int y, int x, int time, boolean type) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
			this.type = type;
		}
	}
	
}
