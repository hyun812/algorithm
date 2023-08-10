
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static int[][] cal;
    static boolean[] isSelected;
    static int[][] tmp;
    static int[] knum;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        isSelected = new boolean[k];
        cal = new int[k][3];
        knum = new int[k];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());

            cal[i][0] = Integer.parseInt(st.nextToken());
            cal[i][1] = Integer.parseInt(st.nextToken());
            cal[i][2] = Integer.parseInt(st.nextToken());
        }

        com(0);
        System.out.println(min);
    }

    public static void com(int cnt) {
        if (cnt == k) {
            tmp = new int[n + 1][m + 1];

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < m + 1; j++) {
                    tmp[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < k; i++) {
                rotation(knum[i]);
            }

            
            for (int i = 1; i < n + 1; i++) {
                int sum = 0;
                for (int j = 1; j < m + 1; j++) {
                    sum += tmp[i][j];
                }
                min = (min > sum) ? sum : min;
            }

            return;
        }

        for (int i = 0; i < k; i++) {
            if (!isSelected[i]) {
                knum[cnt] = i;
                isSelected[i] = true;
                com(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void rotation(int idx) {

        int r = cal[idx][0]; // 3
        int c = cal[idx][1]; // 4
        int s = cal[idx][2]; // 2

        int width = (c + s) - (c - s) + 1;
        int height = (r + s) - (r - s) + 1;

        int cnt = Math.min(width, height) / 2; // 몇번돌릴지

        for (int i = 0; i < cnt; i++) {
            int y = r - s + i;
            int x = c - s + i;
            int temp = tmp[y][x];

            int stx = c - s + i;
            int sty = r - s + i;
            int enx = c + s - i;
            int eny = r + s - i;

            for (int j = 0; j < 4; j++) {
                while (true) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (ny < sty || nx < stx || ny > eny || nx > enx) {
                        break;
                    }

                    tmp[y][x] = tmp[ny][nx];
                    y = ny;
                    x = nx;

                }

            }
            tmp[y][x + 1] = temp;
        }
    }
}
