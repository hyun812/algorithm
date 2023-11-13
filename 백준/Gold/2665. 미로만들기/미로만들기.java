import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dist;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(bf.readLine());
        ans = Integer.MAX_VALUE;
        arr = new int[n][n];
        dist = new int[n][n];
        for(int i=0; i<n; i++) {
             String[] s = bf.readLine().split("");
             for(int j=0; j<n; j++) {
                 arr[i][j] = Integer.parseInt(s[j]);
                 dist[i][j] = Integer.MAX_VALUE;
             }
        }
        
        bfs();
        
        System.out.println(dist[n-1][n-1]);
        
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        
        q.add(new Node(0, 0));
        dist[0][0] = 0;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                // 범위 벗어나면
                if(!outOfIdx(ny, nx)) continue;
                
                if(dist[y][x] < dist[ny][nx]) {
                	if(arr[ny][nx] == 1) {
                		dist[ny][nx] = dist[y][x];
                	}
                	else {
                		dist[ny][nx] = dist[y][x] +1 ;
                	}
                	q.add(new Node(ny, nx));
                }
            }
        }
        
    }
    
    private static boolean outOfIdx(int ny, int nx) {
        if(ny>=0 && ny<n && nx>=0 && nx<n) {
            return true;
        }
        return false;
    }
    
    static class Node {
        int y, x;

        public Node(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
    }
}