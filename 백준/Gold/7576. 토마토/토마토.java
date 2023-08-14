

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int m;
    static int n;
    static int[][] result;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        result = new int[n][m];
        Queue<int[]> q = new LinkedList<int[]>();
        
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                result[i][j] = a;
                arr[i][j] = a;
                if(a == 1) {
                	q.add(new int[] {i, j});
                }
            }
        }
        bfs(q);	
        
        
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(result[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = (max < result[i][j]) ? result[i][j]-1 : max;
            }
        }   

        System.out.println(max);
    }

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void bfs(Queue<int[]> q) {
        visited = new boolean[n][m];

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            visited[y][x] = true;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (outOfIndex(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 0) {
                    q.add(new int[] { ny, nx });
                    visited[ny][nx] = true;
                    
                    if(result[ny][nx] != 0){
                        result[ny][nx] = (result[ny][nx] > result[y][x] +1) ? result[y][x] +1 : result[ny][nx];
                    }else{
                        result[ny][nx] = result[y][x] +1;
                    }
                }
            }
        }
    }

    public static boolean outOfIndex(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < m) {
            return true;
        }

        return false;
    }

}

