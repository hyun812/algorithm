import java.util.*;
import java.io.*;

public class Main {
	static int m, n;
	static int[][] arr;
	static ArrayList<int[]> list;
	static Queue<int[]> q;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		list = new ArrayList<>();
		q = new LinkedList<int[]>();
		ans = 0;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] >= 1) list.add(new int[] {i, j});
			}
		}
		
		bfs();
		System.out.println(ans);
	}

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	private static void bfs() {
		boolean[][] visited = new boolean[m][n];
		
		if(list.size() == 0) {
			ans = 0;
			return;
		}
		int startY = list.get(0)[0];
		int startX = list.get(0)[1];
		q.add(new int[] {startY, startX});
		visited[startY][startX] = true;
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(!outOfIdx(ny, nx)) continue;
				if(visited[ny][nx]) continue;
				if(arr[ny][nx] == 0) continue;
				
				q.add(new int[] {ny, nx});
				visited[ny][nx] = true;
				cnt++;
			}
		}
		
		if(list.size() == 0) {
			ans = 0;
			return;
		}
		
		int[] re = new int[list.size()];
		// 아직 분리되지 않았으면
		if(cnt == list.size()) {
			
			
			for(int i=0; i<list.size(); i++) {
				int remove = 0;
				
				int y = list.get(i)[0];
				int x = list.get(i)[1];
				for(int j=0; j<4; j++) {
					int ny = y+dy[j];
					int nx = x+dx[j];
					
					if(!outOfIdx(ny, nx)) continue;
					if(arr[ny][nx] != 0) continue;
					remove++;
				}
				re[i] = remove;
			}
			
			for(int i=0; i<list.size(); i++) {
				int y = list.get(i)[0];
				int x = list.get(i)[1];
				arr[y][x] -= re[i];
				// 주위에 있는 0의 개수만큼 지웠을 때 그자리가 0이됐으면 리스트에서 삭제
				if(arr[y][x] <= 0) {
					arr[y][x] = 0;
				}
			}
			
			for(int i=0; i<list.size(); i++) {
				int y = list.get(i)[0];
				int x = list.get(i)[1];
				if(arr[y][x] == 0) {
					list.remove(i);
					i--;
				}
			}
			ans++;
			bfs();
		}else {
			return;
		}
		
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<m && nx>=0 && nx<n) {
			return true;
		}
		return false;
	}
	
	
	
}