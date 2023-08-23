
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static int[] cctvDir;
	static int[][] copy;
	static int result = Integer.MAX_VALUE;
	
	static ArrayList<int[]> cctv;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		cctv = new ArrayList<int[]>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 1 || num == 2 || num == 3 || num == 4 || num == 5) {
					cctv.add(new int[] {i , j, num}); // cctv의 좌표와 어떤 cctv인지 저장
				}
				arr[i][j] = num;
			}
		}
		cctvDir = new int[cctv.size()]; // cctv의 방향을 저장
		
		check(0);
		System.out.println(result);
	}
	
	static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dx = {0, 0, -1, 1};
	
	private static void check(int cnt) {
		if(cnt == cctv.size()) {
			copy = new int[n][m];
			for(int i=0; i<n; i++) {
				copy[i] = arr[i].clone();
			}
			
			setting();
			
			int ans = checkresult();
			
			result = (result > ans) ? ans : result;
			return;
			// 카운트 세고 min 구하기
		}
		
		for(int i=0; i<4; i++) {
			cctvDir[cnt] = i;
			check(cnt+1);
		}
	}
	
	private static void setting() {
		for(int i=0; i<cctv.size(); i++) {
			int[] info = cctv.get(i);
			
			int target = info[2]; // 몇번 cctv인지
			int dir = cctvDir[i]; //cctv의 방향
			
			switch (target) {
			case 1 :
				nonCount(info, dir);
				break;
			case 2 :
				if(dir == 0 || dir == 2) {
					nonCount(info, 0);
					nonCount(info, 1);	
				}else {
					nonCount(info, 2);
					nonCount(info, 3);
				}
				break;
			case 3 :
				if(dir == 0) {
					nonCount(info, 0); // 상
					nonCount(info, 3); // 우
				}else if(dir == 1){
					nonCount(info, 1); // 하
					nonCount(info, 2); // 좌
				}else if(dir == 2){
					nonCount(info, 2); // 좌
					nonCount(info, 0); // 상
				}else if(dir == 3){
					nonCount(info, 3); // 우
					nonCount(info, 1); // 하
				}
				break;
			case 4 :
				for(int j=0; j<4; j++) {
					if(dir == j) continue;
					nonCount(info, j);
				}
				break;
			case 5 :
				for(int j=0; j<4; j++) {
					nonCount(info, j);
				}
				break;
			}
			
		}
	}
	
	private static void nonCount(int[] info, int dir) {
		int y = info[0];
		int x = info[1];
		
		while(true) {
			int ny = y+dy[dir];
			int nx = x+dx[dir];
			
			if(!outofindex(ny, nx) || copy[ny][nx] == 6) break;
			
			if(copy[ny][nx] == 0) {
				copy[ny][nx] = -1;
			}
			
			y = ny;
			x = nx;
		}
	}
	
	private static boolean outofindex(int y, int x) {
		if(y < 0 || y >= n || x < 0 || x >= m) {
			return false;
		}
		
		return true;
	}
	
	private static int checkresult() {
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copy[i][j] == 0) ans++; 
			}
		}
		
		return ans;
	}
}