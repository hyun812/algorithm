import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] parents;
	static String ans;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(bf.readLine()); // 도시의 수
        m = Integer.parseInt(bf.readLine()); // 에행 계획에 속한 도시들의 수
        ans = "YES";
        make();
        
        for(int i=1; i<=n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=1; j<=n; j++) {
        		int target = Integer.parseInt(st.nextToken());
        		if(target == 0) continue;
        		union(i, j);
        	}
        }
        
        int root = 0;
        st = new StringTokenizer(bf.readLine());
        int target = Integer.parseInt(st.nextToken());
        root = find(target);
        for(int i=1; i<m; i++) {
        	int temp = Integer.parseInt(st.nextToken());
        	if(find(temp)!=root) {
        		ans = "NO";
        		break;
        	}
        }
        System.out.println(ans);
	}
	
	private static void make() {
		parents = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
		return;
	}
}