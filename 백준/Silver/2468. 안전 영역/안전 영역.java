import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int ans;
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        ans = 1;
        
        int max = 0;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(max < arr[i][j]) max = arr[i][j];
        	}
        }
        
        
        for(int h=1; h<=max; h++) { // 비의 높이 , h이하의 모든 곳이 잠김
        	visited = new boolean[n][n];
        	int cnt = 0;
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			if(visited[i][j]) continue;
        			if(arr[i][j] <= h) continue;
        			bfs(i,j,h);
        			cnt++;
        		}
        	}
        	
        	ans = Math.max(ans, cnt);
        }
        
        
        System.out.println(ans);
       
    }
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    private static void bfs(int startY, int startX, int h) {
    	Queue<int[]> q = new LinkedList<int[]>();
    	q.add(new int[] {startY, startX});
    	visited[startY][startX] = true;
    	
    	while(!q.isEmpty()) {
    		int[] poll = q.poll();
    		int y = poll[0];
    		int x = poll[1];
    		
    		for(int i=0; i<4; i++) {
    			int ny = y+dy[i];
    			int nx = x+dx[i];
    			
    			if(!outOfIdx(ny, nx)) continue;
    			if(visited[ny][nx]) continue;
    			if(arr[ny][nx] <= h) continue;
    			
    			q.add(new int[] {ny, nx});
    			visited[ny][nx] = true;
    		}
    	}
    }
    
    private static boolean outOfIdx(int ny, int nx) {
    	if(ny>=0 && ny<n && nx>=0 && nx<n) {
    		return true;
    	}
    	return false;
    }
    
    
}