
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	
	static int n, k;
	static int ans, mintime;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new int[100002];
		
		if(n>=k) {
			System.out.println(n-k);
			System.out.println(1);
		}else {
			check();
			System.out.println(mintime);
			System.out.println(ans);
		}
	}
	
	private static void check() {
		mintime = Integer.MAX_VALUE/16;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 1;
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			if(mintime < visited[poll]) {
				return;
			}
			for(int i=0; i<3; i++) {
				int temp;
				if(i==0) {
					temp = poll+1;
				}else if(i==1) {
					temp = poll-1;
				}else {
					temp = poll*2;
				}
				
				if(temp == k) {
					mintime = visited[poll];
					ans++;
					
				}
				
				if(temp >=0 && temp < visited.length && (visited[temp] == 0 || visited[temp] == visited[poll]+1)) {
					visited[temp] = visited[poll]+1;
					q.add(temp);
				}
			}
			
			
			
		}
		
	}
	
}
