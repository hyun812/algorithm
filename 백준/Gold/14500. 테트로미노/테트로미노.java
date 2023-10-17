import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] nums;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());        
        
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        
        arr = new int[n][m];
        nums = new int[3];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }
        
        System.out.println(ans);
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    // 4번 이동하고 최대값 확인하기
    private static void dfs(int y, int x, int cnt, int sum) {
        if(cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(!outOfIdx(ny, nx)) continue;
            if(visited[ny][nx]) continue;
            
            visited[ny][nx] = true;
            dfs(ny, nx, cnt+1, sum+arr[ny][nx]);
            visited[ny][nx] = false;
            
            if(cnt == 2) {
            	visited[ny][nx] = true;
                dfs(y, x, cnt+1, sum+arr[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }
    
    // 만들어지지 않는 모양 확인
    // 처음 생각은 시작위치 기준으로 4방 중에서 3개뽑는 방식으로 ㅗ모양 해결하려함
//    private static void impdfs(int y, int x, int start, int cnt) {
//        if(cnt == 3) {
//            int sum = 0;
//            for(int i=0; i<nums.length; i++) {
//                int idx = nums[i];
//                if(!outOfIdx(y+dy[idx], x+dx[idx])) return;
//                
//                sum += arr[y+dy[idx]][x+dx[idx]];
//            }
//            ans = Math.max(ans, sum+arr[y][x]);
//            return;
//        }
//        
//        for(int i=start; i<4; i++) {
//            nums[cnt] = i;
//            impdfs(y, x, i+1, cnt+1);
//        }
//    }
    
    
    private static boolean outOfIdx(int ny, int nx) {
        if(ny>=0 && ny<n && nx>=0 && nx<m) {
            return true;
        }
        return false;
    }
}