import java.io.*;
import java.util.*;

public class Solution {
	static ArrayList<Integer>[] list;
	static int[] visited;
	static int lastpoll;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(bf.readLine()); 
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			visited = new int[101];
			list = new ArrayList[101];
			for(int i=0; i<101; i++) {
				list[i] = new ArrayList();
			}
			ans = -1;
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<len/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
			}
			
			bfs(start);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		int max = Integer.MIN_VALUE;
		visited[start] = 1;
		q.add(start);
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int i : list[poll]) {
				if(visited[i] == 0) {
					q.add(i);
					visited[i] = visited[poll]+1;
				}
			}
			max = visited[poll];
		}
		
		for(int i=0; i<101; i++) {
			if(max != visited[i]) {
				continue;
			}
			
			ans = (ans < i) ? i : ans;
		}
	}
	
}
