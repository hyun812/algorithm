import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int m;
    static int n;
    static int k;
    static int[][] arr;
    static boolean[][] visited;
    static int all;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(bf.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[y][x] = 1;
            }

            all = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        all++;
                        bfs(new int[] { i, j });
                    }
                }
            }
            sb.append(all).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();

        q.add(start);

        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (outOfIndex(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 1) {
                    q.add(new int[] { ny, nx });
                    visited[ny][nx] = true;
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
