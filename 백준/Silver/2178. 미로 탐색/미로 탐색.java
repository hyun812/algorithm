import java.io.*;
import java.util.*;

public class Main {
    // static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();
            for(int j=0; j<m; j++){
                String tar = s.split("")[j];
                arr[i][j] = Integer.parseInt(tar);
            }
        }
        
        bfs(0);

        System.out.println(arr[n-1][m-1]);
    }

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
    
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];

            for(int i=0; i<4; i++){
                int ny = y+dy[i];
                int nx = x+dx[i];

                if(outOfIndex(ny, nx) && arr[ny][nx] == 1){
                    q.add(new int[] {ny , nx});
                    visited[ny][nx] = true;
                    arr[ny][nx] = arr[y][x]+1;
                }
            }
        }   
    }

    public static boolean outOfIndex(int y, int x){
        if(y>=0 && y<n && x>=0 && x<m){
            return true;
        }
        
        return false;
    }
}
