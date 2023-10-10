import java.util.*;
import java.io.*;

public class Main {
	static int ans; // 청소하는 영역의 개수
	static int n, m, y, x, d;
	static int[][] arr;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		st = new StringTokenizer(bf.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 북, 동, 남, 서
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		doit();
		System.out.println(ans);
	}
	
	private static void doit() {
		
		while(true) {
			// 후진했을 때 벽이라면 종료
			if(arr[y][x] == 1) {
				return;
			}
			
			// 현재 칸이 아직 청소되지 않았으면, 청소
			if(arr[y][x] == 0) {
				arr[y][x] = 2;
				ans++;
			}
			
			// 4방 탐색
			int cnt = 0;
			for(int i=0; i<4; i++) {
				// 바라보는 방향을 기준으로 90도씩 돌면서 체크
				d = d-1;
				if(d < 0) d = 3;
				
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(!outOfIdx(ny, nx)) continue;
				if(arr[ny][nx] == 0) {
					y = ny;
					x = nx;
					cnt++;
					break;
				}
			}
			
			// 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			if(cnt == 0) {
				back();
			}
		}
	}
	
	private static void back() {
		switch(d) {
		case 0 :
			y = y+dy[2];
			x = x+dx[2];
			break;
		case 1 :
			y = y+dy[3];
			x = x+dx[3];
			break;
		case 2 :
			y = y+dy[0];
			x = x+dx[0];
			break;
		case 3 :
			y = y+dy[1];
			x = x+dx[1];
			break;
		}
	}
	
	
	private static boolean outOfIdx(int ny, int nx) {
		if(ny>=0 && ny<n && nx>=0 && nx<m) {
			return true;
		}
		return false;
	}
}