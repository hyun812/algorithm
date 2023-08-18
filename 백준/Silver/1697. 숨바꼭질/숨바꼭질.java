
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int n, k;
	static int ans;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new int[100002];
		
		if(n==k) {
			System.out.println(0);
		}else {
			check();	
		}
		
	}
	
	
	private static void check() {
		Queue<Integer> q = new LinkedList<>();
        q.add(n); 
		visited[n] = 1;
        
        while(!q.isEmpty()) {
        	
        	int poll = q.poll();
        	
        	for(int i=0; i<3; i++) {
        		int next;
        		
        		if (i == 0) {
                    next = poll + 1;
                } else if (i == 1) {
                    next = poll - 1;
                } else {
                    next = poll * 2;
                }
    
        		
        		if(next == k) {
        			System.out.println(visited[poll]);
        			return;
        		}
        		
        		if(next >= 0 && next < visited.length && visited[next] == 0) {
        			q.add(next);
        			visited[next] = visited[poll]+1;
        		}
        	}
        	
        }                    
	}
	
	
}
