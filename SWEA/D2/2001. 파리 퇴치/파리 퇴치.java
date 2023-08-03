import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int n;
	static int m;
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<=n-m; i++) {
				for(int j=0; j<=n-m; j++) {
					check(i, j);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
			max =0;
		}
		
		System.out.println(sb.toString());
	}
	
	public static void check(int x, int y) {
		int sum = 0;
		for(int i=x; i<x+m; i++) {
			for(int j=y; j<y+m; j++) {
				sum += arr[i][j];
			}
		}
		
		max = Math.max(sum, max);
	}
}

