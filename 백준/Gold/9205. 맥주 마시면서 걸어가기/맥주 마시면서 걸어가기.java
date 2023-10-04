import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] arr;
	static int startY, startX, endY, endX;
	static ArrayList<int[]> list;
	static boolean[] visited;
	static String ans = "";
	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(bf.readLine());
        
        for(int tc=1; tc<=t; tc++) {
        	n = Integer.parseInt(bf.readLine());
        	
        	st = new StringTokenizer(bf.readLine());
        	startY = Integer.parseInt(st.nextToken());
        	startX = Integer.parseInt(st.nextToken());
        	list = new ArrayList<>();
        	ans = "sad";
        	
        	for(int i=0; i<n; i++) {
        		st = new StringTokenizer(bf.readLine());
        		int y = Integer.parseInt(st.nextToken());
        		int x = Integer.parseInt(st.nextToken());
        		list.add(new int[] {y, x});
        	}
        	
        	st = new StringTokenizer(bf.readLine());
        	endY = Integer.parseInt(st.nextToken());
        	endX = Integer.parseInt(st.nextToken());
        	list.add(new int[] {endY, endX});
        	
        	visited = new boolean[list.size()];
        	bfs();
            
            System.out.println(ans);	 
        }
        
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {startY, startX});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			
			if(y == endY && x == endX) {
				ans = "happy";
				return;
			}
			
			for(int i=0; i<list.size(); i++) { // 편의점 둘러보기
				int[] cur = list.get(i);
				int ny = cur[0];
				int nx = cur[1];
				
				if(visited[i]) continue;
				int ndis = cal(ny, nx, y, x); // 거리차이 계산
				if(ndis > 1000) continue;
				
				visited[i] = true;
				q.add(new int[] {ny, nx});
			}
		}
	}
	
	private static int cal(int ny, int nx, int y, int x) {
		int dis = Math.abs(ny-y)+Math.abs(nx-x);
		return dis;
	}
}