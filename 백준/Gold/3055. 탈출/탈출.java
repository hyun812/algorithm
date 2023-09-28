import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static String[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] startPos;
	static int[] endPos;
	
	static int[][] visited;
	
	static Queue<int[]> q;
	static int ans;
	
	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startPos = new int[2];
        endPos = new int[2];
        map = new String[n][m];
        visited = new int[n][m];
        q = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	String s = st.nextToken();
        	for(int j=0; j<m; j++) {
        		map[i][j] = s.split("")[j];
        		if(map[i][j].equals("S")) {
        			startPos = new int[] {i, j};
        			map[i][j] = ".";
        		}
        		else if(map[i][j].equals("D")) {
        			endPos = new int[] {i, j};
        		}else if(map[i][j].equals("*")) {
        			// 물이 찰 예정인 칸으로 이동할 수 없으므로 큐에 물부터 추가
        			q.add(new int[] {i, j});
        			visited[i][j] = 0;
        		}
        	}
        }
        bfs();
        doit();
        if(ans == 0) {
        	System.out.println("KAKTUS");
        }
        else System.out.println(ans);
	}
	
	static int count;
	private static void bfs() {
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(!outOfIdx(ny, nx)) continue; // 범위 벗어나면 
				if(visited[ny][nx] != 0) continue; // 방문한적이 있으면
				if(!map[ny][nx].equals(".")) continue; // 빈 칸이 아니면
				
				q.add(new int[] {ny, nx});
				visited[ny][nx] = visited[y][x] + 1;
			}
		}
	}
	
	static boolean[][] moleV;
	static void doit() {
		Queue<Mole> mq = new LinkedList<Mole>();
		moleV = new boolean[n][m];
		mq.add(new Mole(startPos[0], startPos[1], 0));
		moleV[startPos[0]][startPos[1]] = true;
		
		while(!mq.isEmpty()){
			Mole mol = mq.poll();
			int y = mol.y;
			int x = mol.x;
			int d = mol.d;
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(!outOfIdx(ny, nx)) continue; // 범위 벗어나면
				
				if(ny==endPos[0] && nx==endPos[1]) {
					ans = d+1;
					return;
				}
				
				if(moleV[ny][nx]) continue; // 방문한적이 있으면
				if(!map[ny][nx].equals(".")) continue; // 빈 칸이 아니면
				
				
				if(visited[ny][nx] != 0 && visited[ny][nx]-1 < d+1) continue; // 물이 찰 예정인 칸
				
				mq.add(new Mole(ny, nx, d+1));
				moleV[ny][nx] = true;
			}
		}
	}
	
	static boolean outOfIdx(int y, int x) {
		if(y>=0 && y<n && x>=0 && x<m) {
			return true;
		}
		return false;
	}
	
	static class Mole {
		int y, x, d;

		public Mole(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Water [y=" + y + ", x=" + x + ", d=" + d + "]";
		}
		
	}
}
