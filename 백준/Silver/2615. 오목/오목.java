import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main
 */
public class Main {
    static int n = 19;
    static int[][] arr = new int[n][n];
    static int[] dx =  { 0, 1, 1, -1 };
    static int[] dy = { 1, 1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = -1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    if(check(i, j, arr[i][j])){
                        result = arr[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
        }

        if(result == -1){
            System.out.println(0);
        }else{
            System.out.println(result);
            System.out.println((x+1) + " " + (y+1));
        }

    }

    public static boolean check(int x, int y, int result) {

        for (int i = 0; i < 4; i++) {
            int cnt = 1;
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            int cx = x - dx[i];
            int cy = y - dy[i];
            if (cx >= 0 && cx < n && cy >= 0 && cy < n && arr[cx][cy] == result) {
                continue;
            }

            // 6까지 봐야함
            while (cnt < 7) {
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == result){
                    cnt++;
                }else{
                    break;
                }
                nx += dx[i];
                ny += dy[i];

            }

            if (cnt == 5) {
                return true;
            }
        }

        return false;
    }
}