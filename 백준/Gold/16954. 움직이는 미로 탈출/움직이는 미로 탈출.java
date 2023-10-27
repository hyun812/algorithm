import java.io.*;
import java.util.*;

public class Main {
	static String[][] arr;

	static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        arr = new String[8][8];
        
        for(int i=0; i<8; i++) {
        	String[] s = bf.readLine().split(""); 
        	for(int j=0; j<8; j++) {
        		arr[i][j] = s[j];
        	}
        }
        bfs();
        System.out.println(ans);
    }
    
    static int[] dy = {0, -1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dx = {0, 0, 0, -1, 1, 1, 1, -1, -1};
    private static void bfs() {
    	Queue<person> q = new ArrayDeque<>();
    	q.add(new person(7, 0));
    	
    	while(!q.isEmpty()) {
    		
    		int size = q.size();
    		for(int j=0; j<size; j++) {
    			person p = q.poll();
        		int y = p.y;
        		int x = p.x;
        		
        		if("#".equals(arr[y][x])) continue;
        		
        		for(int i=0; i<9; i++){
        			int ny = y + dy[i];
        			int nx = x + dx[i];
        			
        			if(!outOfIdx(ny, nx)) continue;
        			if("#".equals(arr[ny][nx])) continue;
        			
        			if(ny == 0 && nx == 7) {
            			ans = 1;
            			return;
            		}
        			if(ny-1 >=0 && "#".equals(arr[ny-1][nx])) continue;
        			
        			
        			q.add(new person(ny, nx));
        		}    			
    		}
    		// 한칸씩 내리기
    		downChess();
    	}
    }
    
    
    private static void downChess() {
    	for(int i=6; i>=0; i--) {
    		for(int j=0; j<8; j++) {
    			arr[i+1][j] = arr[i][j];
    		}
    	}
    	
    	for(int i=0; i<8; i++) {
    		arr[0][i] = ".";
    	}
    }
    
    private static boolean outOfIdx(int ny, int nx) {
    	if(ny>=0 && ny<8 && nx>=0 && nx<8) {
    		return true;
    	}
    	return false;
    }

    static class person {
    	int y, x;

		public person(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
    }
    
    private static void print(String[][] visited) {
    	for(int i=0; i<8; i++) {
    		System.out.println(Arrays.toString(visited[i]));
    	}
    	System.out.println();
    }
}