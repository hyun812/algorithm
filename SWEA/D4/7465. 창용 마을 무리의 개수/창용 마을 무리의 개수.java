
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	static int[] parents;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;		
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());	
			
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ans =0;
			make();
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
				
			}
			
			for(int i=1; i<=n; i++) {
				if(parents[i]==i) ans++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void make() {
		parents = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		else {
			int b = find(parents[a]);
			parents[a] = b;
			return b;
		}
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		else {
			parents[bRoot] = aRoot;
			return true;
		}
	}
}