import java.util.*;
import java.io.*;

public class Main {
    static int n, k, l;
    static int[][] arr;
    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    static HashMap<Integer, String> hash = new HashMap<>();
    static int ans;
    static int[] headpos = {0, 0};
    static int curd; // 현재 방향

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine()); // 보드 크기
        k = Integer.parseInt(bf.readLine()); // 사과의 개수
        arr = new int[n][n];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[y-1][x-1] = 1;
        }

        l = Integer.parseInt(bf.readLine());

        q.add(new int[] { 0, 0 }); // 뱀의 위치
        curd = 3;
        for(int i=0; i<l; i++) {
            st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            hash.put(time, c);
        }
        startGame();

        System.out.println(ans);
    }

    private static void startGame() {
        while (true) {
            ans++; // 이동
            int ny = headpos[0] + dy[curd]; // 이동했을 때
            int nx = headpos[1] + dx[curd];

            if(!outOfIdx(ny, nx) ||  arr[ny][nx] == 2){
                return;
            }

            if(hash.containsKey(ans)){
                curd = didx(curd, hash.get(ans)); // 방향 바꿔주기
            }

            q.add(new int[] {ny, nx});
            headpos = new int[] {ny, nx};

            if(arr[ny][nx] == 0){
                int[] poll = q.poll();
                int y = poll[0];
                int x = poll[1];
                arr[y][x] = 0;
            }

            arr[ny][nx] = 2;

        }
    }

    private static int didx(int curidx, String c){
        switch (curidx){
            case 0: // 위
                // 방향이 위쪽일때
                // L이면 왼쪽 R이면 오른쪽
                if(c.equals("L")){
                    curidx = 2;
                }else if(c.equals("D")){
                    curidx = 3;
                }
                break;
            case 1: // 아래
                // 방향이 아래쪽일때
                // L이면 오른쪽 R이면 왼쪽
                if(c.equals("L")){
                    curidx = 3;
                }else if(c.equals("D")){
                    curidx = 2;
                }
                break;
            case 2: // 왼쪽
                // 방향이 왼쪽일때
                // L이면 아래쪽 R이면 위쪽
                if(c.equals("L")){
                    curidx = 1;
                }else if(c.equals("D")){
                    curidx = 0;
                }
                break;
            case 3: // 오른쪽
                // 방향이 오른쪽일때
                // L이면 위쪽 R이면 아래쪽
                if(c.equals("L")){
                    curidx = 0;
                }else if(c.equals("D")){
                    curidx = 1;
                }
                break;
        }

        return curidx;
    }


    private static boolean outOfIdx(int y , int x) {
        if(y>=0 && y<n && x>=0 && x<n){
            return true;
        }
        return false;
    }
}