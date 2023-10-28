import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int startY, startX, endY, endX;
	static String[][] arr;
	static int ans;
	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        startY = Integer.parseInt(st.nextToken())-1;
        startX = Integer.parseInt(st.nextToken())-1;
        endY = Integer.parseInt(st.nextToken())-1;
        endX = Integer.parseInt(st.nextToken())-1;
        
        arr = new String[n][m];
        ans = 1;
        for(int i=0; i<n; i++) {
        	String[] s = bf.readLine().split("");
        	for(int j=0; j<m; j++) {
        		arr[i][j] = s[j];
        	}
        }
        
        bfs();
        
        System.out.println(ans);
    }
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	// 한번 파동에 갈 수 있는 애들 다 0 으로 만들기 
	// 체크해두고 갈 수 있는 곳이 없을 때 다 0 으로 만들어주면 될듯
	private static void bfs() {
		int[][] visited = new int[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {startY, startX});
		visited[startY][startX] = 0;
		
		Stack<int[]> s = new Stack<>();
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny == endY && nx == endX) {
					return;
				}
				
				if(!outOfIdx(ny, nx)) continue;
				if(visited[ny][nx] != 0) continue;
				if("0".equals(arr[ny][nx])) {
					q.add(new int[] {ny, nx});
				}else {
					s.push(new int[] {ny, nx});
				}
				visited[ny][nx] = visited[y][x] +1;
			}
		}
		
		ans++;
		while(!s.isEmpty()) {
			int[] pop = s.pop();
			int y = pop[0];
			int x = pop[1];
			arr[y][x] = "0";
		}
		bfs();
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<m) {
			return true;
		}
		return false;
	}
}