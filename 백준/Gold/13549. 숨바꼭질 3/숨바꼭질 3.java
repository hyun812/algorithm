import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int ans;
	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        bfs();
        
        System.out.println(ans);
    }
	
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		
		q.add(new int[] {n, 0});
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int pos = poll[0];
			int time = poll[1];
			
			if(pos == m) {
				ans = Math.min(ans, time);
			}
			
			for(int i=0; i<3; i++) {
				int nx = move(i, pos);
				
				if(nx > 100000 || nx < 0) continue;
				if(visited[nx]) continue;
				
				if(i==0) q.add(new int[] {nx, time});
				else q.add(new int[] {nx, time+1});
				
				visited[nx] = true;
			}
		}
	
	}
	private static int move(int idx, int pos) {
		int temp = 0;
		switch(idx) {
		case 0 :
			temp = pos*2;
			break;
		case 2 : 
			temp = pos+1;
			break;
		case 1 : 
			temp = pos-1;
			break;
		}
		
		return temp;
	}
}