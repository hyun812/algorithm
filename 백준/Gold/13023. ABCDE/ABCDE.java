
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int n, m;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList();
		}
		
		visited = new boolean[n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0; i<n; i++) {
			if(ans ==1) break;
			dfs(i, 1);	
		}
		
		
		System.out.println(ans);
	}
	
	private static void dfs(int start, int depth) {
		if(depth == 5) {
			ans = 1;
			return;
		}
		
		visited[start] = true;
		for(int i : list[start]) {
			if(!visited[i]) {
				dfs(i, depth+1);
			}
		}	
		visited[start] = false;
	}
	
}