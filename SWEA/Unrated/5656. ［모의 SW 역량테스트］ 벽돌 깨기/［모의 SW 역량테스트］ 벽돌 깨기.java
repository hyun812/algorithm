import java.io.*;
import java.util.*;

public class Solution {
	static int n, w, h;
	static int[] nums;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t=  Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[h][w];
			nums = new int[n]; // 떨어뜨릴 위치를 저장할 배열
			ans = Integer.MAX_VALUE; // 최대한 많은 벽돌을 제거하고 남은 벽돌의 개수 ( 최솟값 찾아야 함)
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			perm(0, arr);
			
			if(ans == Integer.MAX_VALUE) {
				ans = 0;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 떨어 뜨릴 위치 뽑기 (똑같은 곳에 또 떨어뜨릴 수 있음)
	private static void perm(int cnt, int[][] arr) {
		if(cnt == n) {
			// 남은 벽돌 개수 계산
			int result = cal(arr);
			ans = Math.min(ans, result);
			return;
		}

		int[][] clone = new int[h][w];
		
		for(int i=0; i<w; i++) {
			
			for(int j=0; j<h; j++) {
				for(int k=0; k<w; k++) {
					clone[j][k] = arr[j][k];
				}
			}
			
			// 터질 벽돌이 없으면 넘어가기
			if(clone[h-1][i] == 0) continue;
			
			// 떨어뜨리고 터트리기
			boom(i, clone);
			
			// 내리기
			down(clone);
			
			// 재귀
			perm(cnt+1, clone);
		}
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	private static void boom(int startX, int[][] clone) {
		Queue<Block> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[h][w];
		
		// 구슬을 떨어뜨렸을 때 처음 만나는 벽돌
		for(int i=0; i<h; i++) {
			if(clone[i][startX] == 0) continue;
			if(clone[i][startX] == 1) { // 한개만 뿌수고 더이상 없으므로 return
				clone[i][startX] = 0;
				return;
			}else {
				q.add(new Block(i, startX, clone[i][startX]-1));
				visited[i][startX] = true;
				clone[i][startX] = 0;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			Block poll = q.poll();
			int y = poll.y;
			int x=  poll.x;
			int range = poll.range;
			
			for(int i=1; i<=range; i++) {
				
				for(int j=0; j<4; j++) {
					int ny = y + i*dy[j];
					int nx = x + i*dx[j];
					
					if(!outOfIdx(ny, nx)) continue;
					if(visited[ny][nx]) continue;
					if(clone[ny][nx] == 0) continue;
					if(clone[ny][nx] == 1) {
						clone[ny][nx] = 0;
						continue;
					}
					
					q.add(new Block (ny, nx, clone[ny][nx]-1));
					visited[ny][nx] = true;
					clone[ny][nx] = 0;
				}
			}
		}
	}
	
	private static void down(int[][] clone) {
		for(int i=0; i<w; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			for(int j=h-1; j>=0; j--) {
				if(clone[j][i] == 0) continue;
				q.add(clone[j][i]);
				clone[j][i] = 0;
			}
			
			int idx = h-1;
			while(!q.isEmpty()) {
				int poll = q.poll();
				clone[idx][i] = poll;
				idx--;
			}
		}
	}
	
	private static int cal(int[][] arr) {
		int result = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(arr[i][j] == 0) continue;
				result++;
			}
		}
		
		return result;
	}
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<h && nx>=0 && nx<w) {
			return true;
		}
		return false;
	}
	
	static class Block {
		int y, x, range;

		public Block(int y, int x, int range) {
			super();
			this.y = y;
			this.x = x;
			this.range = range;
		}
	}
}