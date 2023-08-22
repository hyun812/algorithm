
import java.io.*;
import java.util.*;

public class Main {
	static String[][] arr1;
	static String[][] arr2;
	static boolean[][] visited;
	static int color;
	static int noncolor; // 색약 카운트
	static int cnt;
	static int n; // 크기
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine());
		arr1 = new String[n][n];
		arr2 = new String[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String[] s = bf.readLine().split("");
			for(int j=0; j<n; j++) {
				arr1[i][j] = arr2[i][j] =s[j];
				if(s[j].equals("G")) {
					arr2[i][j] = "R";
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					color++;
					bfs(new int[] {i,j}, arr1);
				}
			}
		}
		
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					noncolor++;
					bfs(new int[] {i,j}, arr2);
				}
			}
		}
		
		System.out.println(color + " " + noncolor);
	}
	
	static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dx = {0, 0, -1, 1};
	
	private static void bfs(int[] start , String[][] arr) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			String temp = arr[y][x];
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(!outofindex(ny, nx)) continue;
				
				// 달라서 드갔는데 rg면은 cnt 바꿔줘야함?
				if(!visited[ny][nx] && arr[ny][nx].equals(temp)) {
					q.add(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
				
				
			}
		}
	}
	
	private static boolean outofindex(int y, int x) {
		if(y>=0 && y<n && x>=0 && x<n) {
			return true;
		}
		
		return false;
	}
	
	
}