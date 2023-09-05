import java.util.*;
import java.io.*;

public class Main {
    static int k,w,h;
    static int[][] map;
    static int[][][] visited;

    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우 4
    static int[] dx = {0, 0, -1, 1};
    static int[] ndy = {-2, -2, -1, -1, 1, 1, 2, 2}; // 나이트 이동 방향 8
    static int[] ndx = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new int[h][w][k+1];

        for(int i=0; i<h; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

    }

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0}); // y, x, 말처럼 얼만큼 갔는지
        visited[0][0][0] = 0;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            int cnt = poll[2];  // 말로 움직인 이동횟수

            if(y == h-1 && x == w-1){ // 가장 처음이 최적의 경로
                ans = Math.min(visited[y][x][cnt], ans);
            }

            // 나이트가 이동했던길은 이동할 수 있어야함

            for(int i=0; i<4; i++){ // 일반 원숭이 이동
                int ny = y+dy[i];
                int nx = x+dx[i];
        
                if(!outOfIdx(ny, nx)) continue;
                if(map[ny][nx] != 1 && visited[ny][nx][cnt]==0){ // 벽이아니고 갈 수 있고 방문하지 않았으면
                    q.add(new int[] {ny, nx, cnt});
                    visited[ny][nx][cnt] = visited[y][x][cnt]+1;
                }
            }
            if(k <= cnt) continue;

            for(int i=0; i<8; i++){ // 나이트 이동
                int ny = y+ndy[i];
                int nx = x+ndx[i];

                if(!outOfIdx(ny, nx)) continue;

                if(map[ny][nx] != 1 && visited[ny][nx][cnt+1]==0){ // 벽이아니고 갈 수 있고 방문하지 않았으면
                    q.add(new int[] {ny, nx, cnt+1});
                    visited[ny][nx][cnt+1] = visited[y][x][cnt]+1;
                }
            }
        }
    }

    private static boolean outOfIdx(int y, int x){
        if(y>=0 && y<h && x>=0 && x<w){
            return true;
        }
        return false;
    }
}