import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int n;
    static int ans;


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        ans = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 판다가 탐색할 시작지점
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(dfs(i, j), ans);
            }
        }

        System.out.println(ans);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static int dfs(int y, int x) {

        if(dp[y][x] != 0){
            return dp[y][x];
        }

        dp[y][x] = 1;

        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(arr[ny][nx] > arr[y][x])
                    dp[y][x] = Math.max(dp[y][x], dfs(ny,nx) + 1);
            }

        }
        return dp[y][x];
    }

    private static  boolean outOfIdx(int y, int x){
        if(y>=0 && y<n && x>=0 && x<n){
            return true;
        }
        return false;
    }
}