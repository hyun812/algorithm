import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int startY, startX;
    static PriorityQueue<fish> fishq;
    static int ans;
    static int sharkSize;
    static boolean[][] visited;
    static int cnt; // 물고기 먹을때마다 카운트
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기가 큰 물고기가 있는 칸은 못지나감
        // 크기가 같은 물고기가 있는 칸은 지나갈 수 는 있지만 먹지는 못함
        // 크기가 작은 물고기가 있는 칸은 먹을 수 있음

        // 거리가 가까운 물고기가 많다면 가장 위에 있는 물고기 y좌표
        // 여러마리라면 가장 왼쪽에 있는 물고기 x좌표

        // 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기 1증가
        // 크기가 2인 상어가 물고기 2마리 먹으면 3됨

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        sharkSize = 2;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int in = Integer.parseInt(st.nextToken());
                arr[i][j] = in;

                if (in == 9) {
                    startY = i;
                    startX = j;
                    arr[i][j] = 0;
                }
            }
        }
        fishq = new PriorityQueue<>( ((o1, o2) -> {
            if(o1.distance == o2.distance){
                if(o1.y == o2.y){
                    return o1.x-o2.x;
                } return o1.y-o2.y;
            } return o1.distance - o2.distance;
        }));


        bfs();

        System.out.println(ans);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static void bfs() {
        //초기세팅

        fishq.add(new fish(startY,startX,0));
        visited[startY][startX] = true;


        while (!fishq.isEmpty()) {
            fish f = fishq.poll();
            int y = f.y;
            int x = f.x;
            int d = f.distance;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (!outOfIdx(ny, nx)) continue; // 범위 벗어나면
                if (visited[ny][nx]) continue; // 방문했으면

                visited[ny][nx] = true;
                if (arr[ny][nx] <= sharkSize) {
                    fishq.add(new fish(ny, nx, d + 1));
                }
            }

            if (fishq.peek() != null) {
                fish peek = fishq.peek();
                int y2 = peek.y;
                int x2 = peek.x;
                int d2 = peek.distance;

                if (arr[y2][x2] != 0 && arr[y2][x2] < sharkSize ) { // 먹을 수 있는 물고기면
                    cnt++;
                    if (cnt == sharkSize) {
                        sharkSize++;
                        cnt = 0;
                    }
                    arr[y2][x2] = 0;

                    fishq.clear();
                    fishq.add(new fish(y2, x2, 0));
                    ans += d2;
                    visited = new boolean[n][n];
                    visited[y2][x2] = true;
                }
            }

        }
    }

    private static boolean outOfIdx(int y, int x){
        if(y>=0 && y<n && x>=0 && x<n){
            return true;
        }
        return false;
    }
    static class fish{
        int y, x,distance;

        public fish(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }



}