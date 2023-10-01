import java.util.*;
import java.io.*;

public class Main {
	static int m, n;
	static int[][] arr;
	static int oneC;
	static int time;

	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[m][n];
        oneC = 0;
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1) {
        			oneC++;
        		}
        	}
        }
        
        bfs();
	}
	
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	private static void bfs() {
		visited = new boolean[m][n];
		Queue<int[]> q = new LinkedList<int[]>();
		visited[0][0] = true;
		q.add(new int[] {0, 0});
		int count = 0;
		time++;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(!outOfIdx(ny,nx)) continue;
				if(visited[ny][nx]) continue;
				
				if(arr[ny][nx] == 0) {
					q.add(new int[] {ny, nx});
					visited[ny][nx] = true;	
				}

				if(arr[ny][nx] == 1) {
					arr[ny][nx] = 0;
					visited[ny][nx] = true;
					count++;
				}
			}
		}
		if(oneC - count == 0) {
			System.out.println(time);
			System.out.println(count);
		}else {
			oneC -= count;
			bfs();
		}
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<m && nx>=0 && nx<n) {
			return true;
		}
		return false;
	}
}
