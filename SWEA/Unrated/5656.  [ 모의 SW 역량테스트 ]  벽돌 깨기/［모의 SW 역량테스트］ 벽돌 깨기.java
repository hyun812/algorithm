import java.io.*;
import java.util.*;

public class Solution {
	static int n, w, h;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken()); // 구슬을 떨어트리는 횟수
			w = Integer.parseInt(st.nextToken()); // 가로
			h = Integer.parseInt(st.nextToken()); // 세로

			int[][] map = new int[h][w]; // 현재 벽돌 저장
			ans = Integer.MAX_VALUE; // 출력값 초기화
			
			// 입력 받기
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			select(0, map, Integer.MAX_VALUE);
			
			// 결과 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	 // 구슬 선택하기
	private static void select(int cnt, int[][] map, int res) { // cnt, copy배열, 남은 벽돌 수
		if(res < ans) {  
			ans = res;
		}
		
		if(cnt == n) {
			return;
		}
		
		int[][] copy = new int[h][w];
		
		for(int x=0; x<w; x++) { // 구슬을 떨어트릴 x좌표
			
			// 배열 복사
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					copy[i][j] = map[i][j];
				}
			}
			
			// 구슬의 y좌표 찾기
			for(int y=0; y<h; y++) {
				if(copy[y][x] != 0) {
					// 벽돌 부수기
					crush(y, x, copy);
					
					// 벽돌 내리기 + res 계산
					int remain = down(copy);
					
					// 구슬 더 떨어트리로 가기
					select(cnt+1, copy, remain);	
					break;
				}
			}
		}
	}
	
	private static void crush(int startY, int startX, int[][] copy) {
		Queue<block> q = new LinkedList<>();
		
		q.add(new block(startY, startX, copy[startY][startX]));
		copy[startY][startX] = 0;
		
		while(!q.isEmpty()) {
			block b = q.poll();
			int y = b.y;
			int x = b.x;
			int range = b.ran;
			
			for(int i=0; i<4; i++) {
				for(int j=1; j<range; j++) {
					int ny = y+dy[i]*j;
					int nx = x+dx[i]*j;
					
					if(!outOfIdx(ny, nx)) continue; // 벗어나면
					if(copy[ny][nx] > 1) {
						q.add(new block(ny, nx, copy[ny][nx]));	
					}
					
					copy[ny][nx] = 0;
				}
			}
		}
	}
	
	private static int down(int[][] copy) {
		int remain = 0;
		
		for(int i=0; i<w; i++) {
			int idx = 0;
			
			// 아래에서 위로 올라가면서 탐색
			for(int j=h-1; j>=0; j--) {
				if(copy[j][i] == 0) { // 0이면
					idx++;
				}else { // 0이 아니면
					
					if(idx != 0) {
						copy[j+idx][i] = copy[j][i];
						copy[j][i] = 0;	
					}
					remain++;
				}
			}
		}
		
		return remain;
	}
	
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<h && nx>=0 && nx<w) {
			return true;
		}
		return false;
	}
	
	static class block {
		int y, x, ran;

		public block(int y, int x, int ran) {
			super();
			this.y = y;
			this.x = x;
			this.ran = ran;
		}

		@Override
		public String toString() {
			return "block [y=" + y + ", x=" + x + ", ran=" + ran + "]";
		}
	}
	
}