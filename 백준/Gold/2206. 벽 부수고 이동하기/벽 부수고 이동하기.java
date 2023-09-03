import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][][] visited;

    static class Loc{
        int y,x, cnt, destroyed;

        public Loc(int y, int x, int cnt, int destroyed) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m][2];
        // visited[n][m][0] 은 벽을 한번도 안부순 애들의 탐색
        // visited[n][m][1] 은 벽을 한번 부순 애들의 탐색

        for(int i=0; i<n; i++) {
            String s = bf.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static void bfs() {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0,0,1,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Loc now = q.poll();
            // int y = now.y;
            // int x = now.x;

            if(now.y == n-1 && now.x == m-1){
                System.out.println(now.cnt);
                return;
            }

            for(int i=0; i<4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(!outOfIdx(ny, nx)) continue;

                int next_cnt = now.cnt+1;

                if(arr[ny][nx] == 0) { // 벽이 아니면
                    if(!visited[ny][nx][now.destroyed]){ // 부신 벽이 여태까지 없었으면
                        visited[ny][nx][now.destroyed] = true;
                        q.add(new Loc(ny,nx,next_cnt, now.destroyed));

                    }
                } else if (arr[ny][nx] == 1) { // 벽이면
                    if(now.destroyed == 0 && !visited[ny][nx][now.destroyed+1]){ // 한번도 부순적이 없다면
                        visited[ny][nx][now.destroyed+1] = true;
                        q.add(new Loc(ny,nx,next_cnt,now.destroyed+1));

                    }
                    // 한번 부순적이 있다면 또 부수고 갈수 없기 때문에 pass
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean outOfIdx(int y, int x) {
        if(y>=0 && y<n && x>=0 && x<m) {
            return true;
        }
        return false;
    }
}

