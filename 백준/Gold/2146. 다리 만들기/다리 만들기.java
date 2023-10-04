import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] checked;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int cnt; // 섬의 인덱스를 위한 변수
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		cnt = 2;
		// 0은 바다 1은 육지
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(bf.readLine());
			 for(int j=0; j<n; j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		
		// 섬 나누기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] != 1) continue;
				bfs(i, j);
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 0) continue;
				int res = bridge(i, j);
				if(res == -1) continue;
				min = Math.min(res, min);
			}
		}
		System.out.println(min-1);
		
	}
	
	
	private static int bridge(int startY, int startX) {
		Queue<int[]> q = new LinkedList<>();
		checked = new int[n][n];
		
		q.add(new int[] {startY, startX});
		checked[startY][startX] = 1;
		int num = arr[startY][startX]; // 섬 넘버
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(!outOfIdx(ny, nx)) continue;
				if(checked[ny][nx] != 0) continue;
				
				if(arr[ny][nx] !=0 && arr[ny][nx] != num) { // 이동한 곳이 0이아니고 num과 다르면
					return checked[y][x];
				}
				
				q.add(new int[] {ny, nx});
				checked[ny][nx] = checked[y][x]+1;
			}
		}
		
		return -1;
	}
	
	
	private static void bfs(int startY, int startX) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startY, startX});
		visited[startY][startX] = true;
		arr[startY][startX] = cnt;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(!outOfIdx(ny, nx)) continue;
				if(visited[ny][nx]) continue;
				if(arr[ny][nx] == 0) continue; // 바다면
				if(arr[ny][nx] == 1) {
					q.add(new int[] {ny, nx});
					visited[ny][nx] = true;
					arr[ny][nx] = cnt;
				}
			}
		}
		
		cnt++;
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<n) {
			return true;
		}
		
		return false;
	}
	
}