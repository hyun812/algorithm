import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        set();
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(bf.readLine());
        	
        	int check = Integer.parseInt(st.nextToken());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	if(check == 0) {
        		union(from,to);
        	}else {
        		if(find(from) == find(to)) {
        			sb.append("YES").append("\n");
        		}else {
        			sb.append("NO").append("\n");
        		}
        	}
        }
        System.out.println(sb.toString());
    }
	
	private static void set() {
		parents = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return;
		
		parents[rootB] = rootA;
	}
	
	private static int find(int a) {
		if(parents[a] == a) {
			return a;
		}else {
			return parents[a] = find(parents[a]);
		}
	}
}