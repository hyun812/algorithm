
import java.io.*;
import java.util.*;

public class Solution {
	static int n, b;
	static int[] arr;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			visited = new boolean[n];
			ans = Integer.MAX_VALUE;
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			doit(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	private static void doit(int idx, int sum) {
		if(idx == n) {
			if(sum >= b) {
				ans = Math.min(ans, sum-b);
			}
			return;
		}
		
		visited[idx] = true;
		doit(idx+1, sum+arr[idx]);
		visited[idx] = false;
		doit(idx+1, sum);
	}
}
