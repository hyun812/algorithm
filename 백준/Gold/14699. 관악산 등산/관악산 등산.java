import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static int[] dp;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	static StringBuilder sb;
	static int max;
	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1];
        visited = new boolean[n+1];
        dp = new int[n+1];
        list = new ArrayList[n+1];
        sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
        	list[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=n; i++) { // 정점의 수만큼
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for(int i=0; i<m; i++) { // 간선의 수만큼
        	st = new StringTokenizer(bf.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	if(arr[from] > arr[to]) list[to].add(from);
        	else list[from].add(to);
    		
        }
        
        // 임의의 쉼터에서 내린 다음 등산 시작
        // 쉼터 도착 후 직접 연결된 더 높은 쉼더로 향하는 길등 중 하나를 골라 이동
        // 그런길없으면 등산 종료
        
        Arrays.fill(dp, -1);
        for(int i=1; i<=n; i++) {
        	dfs(i);
        }
        
        for(int i=1; i<=n; i++) {
        	sb.append(dp[i]).append("\n");
        }
        // 최대한 많은 쉼터를 방문
        System.out.println(sb.toString());
    }
    
    private static int dfs(int v) {
    	if(list[v].size() ==  0) {
    		dp[v] = 1;
    		return dp[v];
    	}
    	
    	if(dp[v] != -1) {
    		return dp[v];
    	}
    	
    	for(int i=0; i<list[v].size(); i++) {
    		dp[v] = Math.max(dp[v], dfs(list[v].get(i))+1);
    	}
    	return dp[v];
    }
}