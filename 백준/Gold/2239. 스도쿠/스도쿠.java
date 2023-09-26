
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[9][9];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(bf.readLine());
			String s = st.nextToken();
			for(int j=0; j<9; j++) {
				int a = Integer.parseInt(s.split("")[j]);
				arr[i][j] = a;
				if(a != 0) cnt++;
			}
		}
		doit(cnt);
	}
	
	private static void doit(int cnt) {
		if(cnt == 81) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int[] zero = zeroCheck();
		if(zero != null) {
			int i = zero[0];
			int j = zero[1];
			for(int k=1; k<=9; k++) {
				if(!check(i, j, k)) continue;
				
				arr[i][j] = k;
				doit(cnt+1);
				arr[i][j] = 0;
			}	
		}
		
	}
	
	private static int[] zeroCheck() {
		int[] zero = null;
		roop1 : for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(arr[i][j] != 0) continue;
				
				
				zero = new int[] {i, j};
				
				break roop1;
			}
		}
		return zero;
	}
	
	private static boolean check(int y, int x, int num) {
		
		for(int i=0; i<9; i++) {
			if(arr[i][x] == num) return false;
		}
		
		for(int i=0; i<9; i++) {
			if(arr[y][i] == num) return false;
		}
		
		int startY = (y/3)*3;
		int startX = (x/3)*3;
		
		for(int i=startY; i<startY+3; i++) {
			for(int j=startX; j<startX+3; j++) {
				if(arr[i][j] == num) return false;
			}
		}
		
		
		return true;
	}
	
}
