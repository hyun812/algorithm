import java.util.*;
import java.io.*;

public class Main {
	static int m,n;
	static int[][] arr;
	static ArrayList<int[]> list;
	static int ans;
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[m][n];
        list = new ArrayList<>();
        ans = 0;
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(bf.readLine());
        	for(int j=0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        bfs(0, 0);
        
        System.out.println(ans);
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    private static void bfs(int startY, int startX) {
    	boolean[][] visited = new boolean[m][n];
    	Queue<int[]> q = new LinkedList<int[]>();
    	List<int[]> li = new ArrayList<>();
    	
    	q.add(new int[] {startY, startX});
    	visited[startY][startX] = true;
    	arr[startY][startX] = 2;
    	
    	while(!q.isEmpty()) {
    		int[] poll = q.poll();
    		int y = poll[0];
    		int x = poll[1];
    		
    		for(int i=0; i<4; i++) {
    			int ny = y+dy[i];
    			int nx = x+dx[i];
    			
    			if(!outOfIdx(ny, nx)) continue; // 범위 벗어났으면
    			if(visited[ny][nx]) continue; // 이미 방문했으면
    			if(arr[ny][nx] == 0 || arr[ny][nx] == 2) { 
    				q.add(new int[] {ny, nx});
    				visited[ny][nx] = true;
    				arr[ny][nx] = 2;
    			}
    			else if(arr[ny][nx] == 1) { // 공기와 맞닿는 치즈들 list에 담기
    				visited[ny][nx] = true;
    				li.add(new int[] {ny, nx});
    			}
    		}
    	}
    	
    	if(li.size() == 0) {
    		return;
    	}else {
    		doit(li);
    	}
    }
    
    private static void doit(List<int[]> list) {
    	boolean[] zero = new boolean[list.size()];

        for(int i=0; i<list.size(); i++) {
    		int y = list.get(i)[0];
    		int x = list.get(i)[1];
    		
    		int cnt = 0;
    		for(int j=0; j<4; j++) {
    			int ny = y+dy[j];
    			int nx = x+dx[j];
    			
    			if(!outOfIdx(ny, nx)) continue;
    			if(arr[ny][nx] == 2) {
    				cnt++;
    			}
    		}
    		
    		if(cnt >= 2) {
    			zero[i] = true;
    		}
    	}
    	
    	for(int i=0; i<list.size(); i++) {
    		if(zero[i]) {
    			arr[list.get(i)[0]][list.get(i)[1]] = 2;
    		}
    	}
    	ans++;
    	bfs(0,0);
    }
    
    
    private static boolean outOfIdx(int ny, int nx) {
    	if(ny>=0 && ny<m && nx>=0 && nx<n) {
    		return true;
    	}
    	return false;
    }
}