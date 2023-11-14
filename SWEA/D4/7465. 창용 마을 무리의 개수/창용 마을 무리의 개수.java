import java.io.*;
import java.util.*;

public class Solution {
	static int n, m;
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			ans = 0;
			make();
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				union(from, to);
			}
			
			
			for(int i=1; i<=n; i++) {
				if(i == arr[i]) {
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	private static int find(int a) {
		
		if(a == arr[a]) return a;
//		
//		arr[a] = find(arr[a]);
		
		return arr[a] = find(arr[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		arr[bRoot] = aRoot;
		return true;
	}
	
	
	private static void make() {
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
	}
}