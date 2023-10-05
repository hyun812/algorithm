import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int startY, startX;
	static int ans;
	static int Bsize, Bcnt; // 아기상어의 크기와 그 크기 계산을 위한 cnt변수
	static Queue<fish> q;
	// 처음 아기상어의 크기는 2
	// 자신의 크기보다 작은 물고기만 먹을 수 있음
	// 자신과 크기가 같은 물고기는 먹을 순없지만 지나갈 수는 있음
	// 먹을 수 있는 물고기가 1마리보다 많으면 거리가 가까운순
	// 거리가 가까운 물고기가 여러개면 가장위에 있는 물고기 , 그것도 여러개면 가장 왼쪽
	// 아기상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1증가
	// 몇초동안 엄마상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하라!!
	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(bf.readLine().trim()); // 크기
        arr = new int[n][n];
        Bsize = 2;
        Bcnt = 0;
        startY = startX = 0;
        q = new PriorityQueue<>();
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 9) {
            		startY = i;
        			startX = j;
        			arr[i][j] = 0;
        		}
        	}
        }
        
        bfs();
        System.out.println(ans);
	}
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	private static void bfs() {
		visited = new boolean[n][n];
		q.add(new fish(startY, startX, 0));
		visited[startY][startX] = true;
		
        while(!q.isEmpty()) {
        	fish f = q.poll();
        	int y = f.y;
        	int x = f.x;
        	
        	for(int i=0; i<4; i++) {
        		int ny = y + dy[i];
        		int nx = x + dx[i];
        		
        		if(!outOfIdx(ny, nx)) continue; // 범위를 벗어났으면
        		if(visited[ny][nx]) continue; // 방문했던 적이 있으면
        		if(Bsize < arr[ny][nx]) continue; // 아기 상어의 사이즈 보다 크면

        		visited[ny][nx] = true;
        		q.add(new fish(ny, nx, f.dis+1));
        	}
        	
        	if(!q.isEmpty()) {
        		fish fp = q.peek();
        		int y1 = fp.y;
        		int x1 = fp.x;
        		
        		// 먹을 수 있는 물고기 이면
        		if(arr[y1][x1] != 0 && Bsize > arr[y1][x1]) { // 0이아니고 아기상어 사이즈보다 작으면
        			Bcnt++;
        			if(Bcnt == Bsize) {
        				Bcnt =0;
        				Bsize++;
        			}
        			arr[y1][x1] = 0;
        			
        			q.clear();
        			
        			q.add(new fish(y1, x1, 0));
        			visited = new boolean[n][n];
        			visited[y1][x1] = true;
        			
        			ans += fp.dis;
        		}
        		
        	}
        }
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<n) {
			return true;
		}
		return false;
	}
	
	static class fish implements Comparable<fish>{
		int y, x, dis;

		public fish(int y, int x, int dis) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
		}

		@Override
		public String toString() {
			return "fish [y=" + y + ", x=" + x + ", dis=" + dis + "]";
		}

		@Override
		public int compareTo(fish o) {
			if(this.dis == o.dis) {
				if(this.y == o.y) {
					return this.x - o.x;
				}else {
					return this.y - o.y;
				}
			}else {
				return this.dis-o.dis;
			}
		} 
	}
}