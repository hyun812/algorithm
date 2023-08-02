
import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int t= Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(bf.readLine());
			
			arr = new int[n][n];
			
			check();
			System.out.println("#"+tc);
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}
	
	
	
	public static void check() {
		int x = 0;
		int y = 0;
		arr[x][y] = 1;
		int cnt = 1;
		
		while(true) {
			for(int i=0; i<4; i++) {
				while(true) {
					if( cnt == n*n) return;
					if(x+dx[i] >=0 && x+dx[i] < n && y+dy[i] >=0 && y+dy[i] < n) {
						if(arr[x+dx[i]][y+dy[i]] != 0) break;
						cnt++;
						arr[x+dx[i]][y+dy[i]] = cnt;
						x += dx[i];
						y += dy[i];
						
					}
					else {
						break;
					}
				}	
			}	
		}
		
			
			
		
		
		
	}
}





