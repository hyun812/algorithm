import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
    static ArrayList<Integer>[] heavyList;
    static ArrayList<Integer>[] lightList;
    static int maxCnt;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;
        maxCnt = n/2;
        heavyList = new ArrayList[n+1];
        lightList = new ArrayList[n+1];
        for(int i=0; i<=n; i++ ) {
        	heavyList[i] = new ArrayList<>();
        	lightList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(bf.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	heavyList[from].add(to);
        	lightList[to].add(from);
        }
        
        // n이 홀수라면
        // n/2 한 개수가 앞 뒤로 있어야 중간임
        // 더 가벼운 링크드리스트랑 더 무거운 링크드리스트를 만들고
        // 더 무거운게 n/2 보다 많거나
        // 더 작은게 n/2보다 많으면 절대 될수 없는거임
        
        for(int i=1; i<=n; i++) {
        	int a = dfs(i);	
        	int b = dfs2(i);
        	
        	if(a > maxCnt || b> maxCnt) {
//        		System.out.println(a);
        		ans++;
        	}
        }
        
        
        System.out.println(ans);
    }
    
    private static int dfs(int start) {
    	Queue<Integer> q = new ArrayDeque<>();
    	boolean[] visited = new boolean[n+1];
    	
    	q.add(start);
    	visited[start] = true;
    	int cnt = 0;
    	while(!q.isEmpty()) {
    		int poll = q.poll();
    		
    		for(Integer i : heavyList[poll]) {
    			if(visited[i]) continue;
    			q.add(i);
    			visited[i] = true;
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
    private static int dfs2(int start) {
    	Queue<Integer> q = new ArrayDeque<>();
    	boolean[] visited = new boolean[n+1];
    	
    	q.add(start);
    	visited[start] = true;
    	int cnt = 0;
    	while(!q.isEmpty()) {
    		int poll = q.poll();
    		
    		for(Integer i : lightList[poll]) {
    			if(visited[i]) continue;
    			q.add(i);
    			visited[i] = true;
    			cnt++;
    		}
    	}
    	return cnt;
    }
}