
import java.io.*;
import java.util.*;

public class Main {
	static int r, c;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		r = Integer.parseInt(st.nextToken()); // 세로
		c = Integer.parseInt(st.nextToken()); // 가로
		
		arr = new int[r][c];
		
		for(int i=0; i<r; i++) {
			String s = bf.readLine();
			
			for(int j=0; j<c; j++) {
				arr[i][j] = s.charAt(j) -'A';
			}
		}
		
		dfs(0, 0, 1);
		
		System.out.println(result);
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[] alpha = new boolean[26];
	static int result = Integer.MIN_VALUE;
	
	private static void dfs(int sty, int stx, int len) {
		alpha[arr[sty][stx]] = true;
		result = (result < len) ? len : result;
		
		for(int i=0; i<4; i++) {
			int ny = sty + dy[i];
			int nx = stx + dx[i];
			
			if(!outofindex(ny, nx)) continue;
			
			if(!alpha[arr[ny][nx]]) {
				dfs(ny, nx, len+1);
				alpha[arr[ny][nx]] = false;	
			}
			
		}
		
	}

	private static boolean outofindex(int y, int x) {
		if(y>=0 && y< r && x>=0 && x<c) {
			return true;
		}
			
		return false;
	}
}