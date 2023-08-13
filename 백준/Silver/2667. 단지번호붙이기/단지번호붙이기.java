import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Integer> al = new ArrayList<>();
    static int all = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    all++;
                    bfs(new int[] { i, j });
                }
            }
        }

        sb.append(all).append("\n");

        Collections.sort(al);

        for (int i = 0; i < al.size(); i++) {
            sb.append(al.get(i)).append("\n");
        }
        System.out.println(sb.toString());

    }

    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };

    public static void bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();

        int cnt = 1;
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
                    cnt++;
                }
            }
        }

        al.add(cnt);

    }

    public static boolean outOfIndex(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < n) {
            return true;
        }

        return false;
    }

}
