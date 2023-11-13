import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    static boolean flag;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        arr = new String[12][6];
        ans = 0;
        for(int i=0; i<12; i++) {
        	String[] s = bf.readLine().split("");
        	for(int j=0; j<6; j++) {
        		arr[i][j] = s[j];
        	}
        }
        
        doit();
        
        System.out.println(ans);
    }
    
    private static void doit() {
    	
    	boolean[][] visited = new boolean[12][6];
    	flag = false;
    	
    	for(int i=0; i<12; i++) {
    		for(int j=0; j<6; j++) {
    			if(arr[i][j].equals(".")) continue;
    			dfs(i, j, visited);
    		}
    	}
    	if(flag) { // 연쇄작용 일어난거임
    		ans++;
    		// 내리고
    		
    		down();
    		// doit 다시 호출
    		doit();
    	}else {
    		return;
    	}
    	
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    private static void dfs(int startY, int startX, boolean[][] visited) {
    	Queue<int[]> q = new ArrayDeque<>();
    	Stack<int[]> s = new Stack<>();
    	q.add(new int[] {startY, startX});
    	
    	String target = arr[startY][startX];
    	int cnt = 0;
    	while(!q.isEmpty()) {
    		int[] poll = q.poll();
    		int y = poll[0];
    		int x = poll[1];
    		
    		for(int i=0; i<4; i++){
    			int ny = y + dy[i];
    			int nx = x + dx[i];
    			
    			if(!outOfIdx(ny, nx)) continue; // 범위 벗어나지 않고
    			if(visited[ny][nx]) continue; // 방문한적이 없고
    			
    			if(arr[ny][nx].equals(target)) { // target와 일치하면
    				q.add(new int[] { ny, nx });
    				visited[ny][nx] = true;
    				s.add(new int[] { ny, nx });
    				cnt ++;
    			}
    		}
    	}
    	
    	if(cnt >= 4) {
    		flag = true;
    		while(!s.isEmpty()) {
    			int[] pop = s.pop();
    			arr[pop[0]][pop[1]] = ".";
    		}
    	}
    }
    
    private static void down() {
    	Queue<String> q = new ArrayDeque<>();
    	for(int i=0; i<6; i++) {
    		for(int j=11; j>=0; j--) {
    			if(arr[j][i].equals(".")) continue;
    			q.add(arr[j][i]);
    		}
    		
    		int idx = 11;
    		while(!q.isEmpty()) {
    			String s = q.poll();
    			arr[idx][i] = s;
    			idx--;
    		}
    		
    		for(int j=idx; j>=0; j--) {
    			arr[j][i] = ".";
    		}
    	}
    }
    
    private static boolean outOfIdx(int ny, int nx) {
    	if(ny>=0 && ny<12 && nx>=0 && nx<6) {
    		return true;
    	}
    	return false;
    }
    
    private static void print() {
    	for(int i=0; i<12; i++) {
    		System.out.println(Arrays.toString(arr[i]));
    	}
    	System.out.println();
    }
}