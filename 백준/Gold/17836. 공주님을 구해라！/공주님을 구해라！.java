import java.io.*;
import java.util.*;

public class Main {
	static int n, m, t;
	static int[][] arr;

	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());        
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        ans = -1;
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=0;j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        bfs();
        if(ans == -1) {
        	System.out.println("Fail");
        }else {
        	System.out.println(ans);	
        }
        
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    private static void bfs() {
    	Queue<Hero> q = new LinkedList<>();
    	boolean[][][] visited = new boolean[n][m][2]; // 검이 없을 때 (0) 와 있을 때 (1)
    	
    	q.add(new Hero(0, 0, 0, false));
    	visited[0][0][0] = true;
    	
    	while(!q.isEmpty()) {
    		Hero h = q.poll();
    		
    		if(t < h.time) break;
    		
    		if(h.y == n-1 && h.x == m-1) {
    			ans = h.time;
    			return;
    		}
    		
    		for(int i=0; i<4; i++) {
    			int ny = h.y + dy[i];
    			int nx = h.x + dx[i];
    			
    			if(!outOfIdx(ny, nx)) continue;
    			if(h.sword) {
    				if(visited[ny][nx][1]) continue;
    				q.add(new Hero(ny, nx, h.time+1, h.sword));
    				visited[ny][nx][1] = true;
    			}else {
    				if(visited[ny][nx][0]) continue;
    				if(arr[ny][nx] == 1) continue;
    				if(arr[ny][nx] == 2) {
    					q.add(new Hero(ny, nx, h.time+1, true));
    					visited[ny][nx][0] = true;
    				}else {
    					q.add(new Hero(ny, nx, h.time+1, h.sword));
    					visited[ny][nx][0] = true;		
    				}
    			}
    			
    		}
    	}	
    	
    }
    
    private static boolean outOfIdx(int ny, int nx) {
    	if(ny>=0 && ny<n && nx>=0 && nx<m) {
    		return true;
    	}
    	return false;
    }
    
    
    static class Hero {
    	int y, x, time;
    	boolean sword;

    	public Hero(int y, int x, int time, boolean sword) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
			this.sword = sword;
		}
    }
}