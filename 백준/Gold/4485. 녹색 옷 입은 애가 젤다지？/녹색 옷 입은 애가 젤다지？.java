import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr, size;
    static boolean[][] visited;
    static int startY, startX;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;
        while(true) {
            n = Integer.parseInt(bf.readLine().trim());
            if(n == 0) return; // n이 0이면 종료
            
            arr = new int[n][n]; // 동굴을 저장할 배열
            size = new int[n][n];
            visited = new boolean[n][n];
            
            for(int i=0; i<n; i++) { // 입력받기
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    size[i][j] = Integer.MAX_VALUE;
                }
            }
            bfs();
            System.out.println("Problem " + t + ": " + size[n-1][n-1]);
            t++;
        }
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    private static void bfs() {
        Queue<node> q = new PriorityQueue<>();
        
        visited[0][0] = true;        
        q.add(new node(0, 0, arr[0][0]));

        
        while(!q.isEmpty()) {
        	
            node poll = q.poll();
            int y = poll.y;
            int x = poll.x;
            int cost = poll.cost;
            
            for(int i=0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                
                if(!outOfIdx(ny, nx)) continue; // 범위 벗어나면
                if(visited[ny][nx]) continue;
                if(size[ny][nx] > arr[ny][nx]+cost) {
                    visited[ny][nx] = true;
                    size[ny][nx] = arr[ny][nx]+cost;
                    q.add(new node(ny, nx, size[ny][nx]));
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
    
    static class node implements Comparable<node>{
        int y, x, cost;
        
        public node(int y, int x, int cost) {
            super();
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost - o.cost;
        }
        
    }
    
}