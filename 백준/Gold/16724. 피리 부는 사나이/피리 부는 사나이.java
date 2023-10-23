import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static String[][] arr;
    static int[][] visited;
    static int ans, idx =1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());        
        
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        
        arr = new String[n][m];
        ans = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            String[] s = st.nextToken().split("");
            for(int j=0; j<m; j++) {
                arr[i][j] = s[j];
            }
        }
        
        visited = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j] != 0) continue;
                visited[i][j] = idx;
                dfs(i, j);
            }
        }
        System.out.println(ans);
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    private static void dfs(int startY, int startX) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] {startY, startX});
        
        while(!stack.isEmpty()) {
            int[] pop = stack.pop();
            int y = pop[0];
            int x = pop[1];
            
            
            int index = getDisIdx(arr[y][x]);
            int ny = y+dy[index];
            int nx = x+dx[index];
            
            // 방문했던 적이 없다면
            if(visited[ny][nx] == 0) {
            	visited[ny][nx] = idx;
                stack.add(new int[] {ny, nx});	
            }else { // 방문했던 적이 있으면
            	if(visited[ny][nx] == idx) { // 방문했던 곳인데 idx가 같다면 사이클이 발생한 거임
            		ans++; // 그때만  SAFE ZONE 값을 늘려줌
            	}
            	// 그게 아니라면 idx만 늘려줌
            	idx++;
            }
        }
    }
    
    private static int getDisIdx(String d) {
        int idx = 0;
        if(d.equals("U")) {
            idx = 0;
        }else if(d.equals("D")) {
            idx = 1;
        }else if(d.equals("L")) {
            idx = 2;
        }else if(d.equals("R")) {
            idx = 3;
        }
        return idx;
    }
}