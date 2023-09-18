import java.io.*;
import java.util.*;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int startY;
    static int startX;
    static int[] endPos;
    static int ans;

    static public class Player {
        int y, x, time;
        public Player(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());
        for(int tc=1; tc<=t; tc++) {
            n = Integer.parseInt(bf.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            endPos = new int[2];
            ans = -1;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(bf.readLine());
            startY = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            endPos[0] = Integer.parseInt(st.nextToken());
            endPos[1] = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println("#" + tc + " " + ans);
        }
    }
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static void bfs(){
        Queue<Player> q = new ArrayDeque<>();
        q.add(new Player(startY, startX, 0));
        visited[startY][startX] = true;

        while (!q.isEmpty()){
            Player player = q.poll();
            int y = player.y;
            int x = player.x;
            int time = player.time;

            if(y == endPos[0] && x == endPos[1]){
                ans = time;
                return;
            }

            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(!outOfIdx(ny, nx)) continue; // 범위 벗어나면
                if(arr[ny][nx] == 1) continue; // 장애물
                if(visited[ny][nx]) continue; // 이미 방문한 곳
                if(arr[ny][nx] == 2 && time % 3 != 2) {
                    q.add(new Player(y, x, time+1)); // 앞이 소용돌이인데 지나갈 수 없으면
                    visited[y][x] = true;
                    continue;
                }

                q.add(new Player(ny, nx, time+1)); // 앞이 소용돌이인데 지나갈 수 없으면
                visited[ny][nx] = true;
            }
        }
    }

    private static boolean outOfIdx(int y, int x){
        if(y>=0 && y<n && x>=0 && x<n) return true;
        return false;
    }
}