import java.io.*;
import java.util.*;

public class Solution {
    static int n, m;
    static int[][] arr;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken()); // 보드 한변의 길이
            m = Integer.parseInt(st.nextToken()); // 돌을 놓는 횟수

            arr = new int[n][n];

            int center = n / 2; // 2 3 4

            arr[center - 1][center - 1] = 2;
            arr[center - 1][center] = 1;
            arr[center][center - 1] = 1;
            arr[center][center] = 2;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int type = Integer.parseInt(st.nextToken()); // 1이면 흑 2면 백

                oneStep(y, x, type);
            }

            int bans = 0;
            int wans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        bans++;
                    } else if (arr[i][j] == 2) {
                        wans++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(bans).append(" ").append(wans).append("\n");

        }
        System.out.println(sb.toString());
    }

    // 자리에 놓고 8방 탐색 후에 다른색돌이있으면 그끝에 내돌이있는지 확인하기

    static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };
    static int[] dx = { 0, 0, -1, 1, 1, 1, -1, -1 };

    private static void oneStep(int y, int x, int type) {
        arr[y][x] = type;

        for (int i = 0; i < 8; i++) {
            int ny = y;
            int nx = x;
            while (true) {
                ny += dy[i];
                nx += dx[i];

                if (!outOfIdx(ny, nx))
                    break; // 범위 벗어나면 종료
                if (arr[ny][nx] == type)
                    break; // 같은 색깔이면 종료
                if (arr[ny][nx] == 0)
                    break; // 빈칸이면 종료

                // 다른 색깔이면 ny, nx 는 다른 색깔만난거
                int nny = ny;
                int nnx = nx;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {nny, nnx});
                while (true) {
                    nny += dy[i];
                    nnx += dx[i];
                    if (!outOfIdx(nny, nnx))
                        break; // 범위 벗어나면 종료
                    if (arr[nny][nnx] == 0)
                        break; // 빈칸이면 종료
                    if (arr[nny][nnx] == arr[ny][nx]) {
                        q.add(new int[] { nny, nnx });
                    } else if (arr[nny][nnx] != arr[ny][nx]) {
                        // 다른거 만나면 끝까지 가면서 거기에 나랑같은색깔이있으면 사이에있는애들 다 바꿔주기
                        while (!q.isEmpty()) {
                            int[] poll = q.poll();
                            int py = poll[0];
                            int px = poll[1];

                            arr[py][px] = arr[y][x];
                        }
                        break;
                    }
                }
            }
        }
    }

    private static boolean outOfIdx(int ny, int nx) {
        if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
            return true;
        }
        return false;
    }
}