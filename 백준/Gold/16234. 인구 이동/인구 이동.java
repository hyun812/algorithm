import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static int n,l,r;
	static int[][] arr;
	static boolean[][] visited;
	static int ans;
	static boolean fl;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 차이 나는게 있으면 반복
		while(true) {
			// true면 반복
			boolean flag = repeat();
			if(!flag) break;
		}
		
		
		System.out.println(ans);
	}
	
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	private static boolean repeat() {
		visited = new boolean[n][n];
		fl = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j]) continue;
				openLine(i, j);		
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int p = arr[i][j];
				for(int k=0; k<4; k++) {
					int ny = i+dy[k];
					int nx = j+dx[k];
					if(!outOfIdx(ny, nx)) continue;

					int np = arr[ny][nx];
					if(rangeCheck(p, np)) return true;
					
				}
			}
		}
		return false;
	}
	
	private static void openLine(int startY, int startX) {
		Queue<int[]> q = new LinkedList<int[]>();
		Set<Integer> set = new HashSet<>();
		
		q.add(new int[] {startY, startX});
		visited[startY][startX] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			int p = arr[y][x];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(!outOfIdx(ny, nx)) continue;
				if(visited[ny][nx]) continue;
				int np = arr[ny][nx];
				if(!rangeCheck(p, np)) continue;
				
				set.add(n*y + x);
				set.add(n*ny + nx);
				
				visited[ny][nx] = true;
				q.add(new int[] {ny, nx});
			}
		}
		
		int sum = 0;
		int size = set.size();
		if(size <= 1) {
			return;
		}else {
			for(int i : set) {
				sum += arr[i/n][i%n];
			}
			// 각 칸 = 연합의 인구수 / 연할을 이루고 있는 칸의 개수
			int each = sum / size;
			for(int i : set) {
				// 인구 이동 
				arr[i/n][i%n] = each;
			}
			if(!fl) {
				ans++;
				fl = true;
			}
			
		}
	}
	
	// 인구차이 확인
	private static boolean rangeCheck(int p, int np) {
		int diff = Math.abs(np-p);
		// 인구차이가 l명 이상 r명 이하라면 국경선이 열림
		if(diff >= l && diff <= r) {
			return true;
		}
		return false;
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<n) {
			return true;
		}
		return false;
	}
	
}