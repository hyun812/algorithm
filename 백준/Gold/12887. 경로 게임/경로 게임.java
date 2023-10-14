import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static String[][] arr;
	static int min;
	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(bf.readLine());
        arr = new String[2][n];
        
        
        int cnt = 0; // .의 개수
        for(int i=0; i<2; i++) {
        	String[] s = bf.readLine().split("");
        	for(int j=0; j<n; j++) {
        		arr[i][j] = s[j];
        		if(arr[i][j].equals(".")) cnt++;
        	}
        }
        
        min = Integer.MAX_VALUE;
        for(int i=0; i<2; i++) {
        	if(arr[i][0].equals(".")) {
        		bfs(i,0);		
        	}
        }
        
        ans = cnt-min;
        
    	System.out.println(ans);	
        
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    private static void bfs(int startY, int startX) {
    	Queue<int[]> q = new LinkedList<int[]>();
    	int[][] visited = new int[2][n];
    	
    	q.add(new int[] {startY, startX});
    	visited[startY][startX] = 1;
    	
    	while(!q.isEmpty()) {
    		int[] poll = q.poll();
    		int y = poll[0];
    		int x = poll[1];
    		
    		if( (y==0 && x==n-1) || (y==1 && x==n-1)) {
    			min = Math.min(min, visited[y][x]);
    			return;
    		}
    		
    		for(int i=0; i<4; i++) {
    			int ny = y+dy[i];
    			int nx = x+dx[i];
    			
    			if(!outOfIdx(ny, nx)) continue;
    			if(visited[ny][nx] != 0) continue;
    			if(arr[ny][nx].equals("#")) continue;
    			
    			q.add(new int[] {ny, nx});
    			visited[ny][nx] = visited[y][x] + 1;
    		}
    	}
    }
    
    private static boolean outOfIdx(int ny, int nx) {
    	if(ny>=0 && ny<2 && nx>=0 && nx<n ) {
    		return true;
    	}
    	return false;
    }
    
    
    
}