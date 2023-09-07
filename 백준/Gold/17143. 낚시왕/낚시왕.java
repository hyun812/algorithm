import java.util.*;
import java.io.*;

public class Main {
    static int r, c, m;
    static Shark[][] map, clone;
    static int ans;
    static Queue<Shark> q;

    static class Shark { // 상어
        int y, x;
        int ss, sd, sz;  // 순서대로 속력, 이동방향, 크기
        public Shark(int y, int x, int ss, int sd, int sz) {
            this.y = y;
            this.x = x;
            this.ss = ss;
            this.sd = sd;
            this.sz = sz;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken()); // y
        c = Integer.parseInt(st.nextToken()); // x
        m = Integer.parseInt(st.nextToken()); // 상어의 수

        map = new Shark[r + 1][c + 1];
        clone = new Shark[r + 1][c + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int sr = Integer.parseInt(st.nextToken()); // 상어 r
            int sc = Integer.parseInt(st.nextToken()); // 상어 c
            int ss = Integer.parseInt(st.nextToken()); // 상어 속력
            int sd = Integer.parseInt(st.nextToken()); // 상어 이동방향
            int sz = Integer.parseInt(st.nextToken()); // 상어 크기
            Shark shark = new Shark(sr, sc, ss, sd, sz);
            map[sr][sc] = shark;
        }

        for (int i = 1; i <= c; i++) { // 오른쪽으로 한칸씩 이동
            doit(i);
        }

        System.out.println(ans);
    }

    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 1, -1}; // 위, 아래, 오른쪽, 왼쪽

    private static void doit(int startX) {
        for (int i = 1; i <= r; i++) {
            Shark shark = map[i][startX];
            // 같은 열에 상어가 없으면 continue;
            if (shark == null) continue;

            ans += shark.sz; // 잡은 상어 크기 더하기
            map[i][startX] = null; // 잡은 상어 map에서 없애주기
            break; // 같은 열 중에서 가장 가까이 있는 상어를 잡으면 break
        }
        
        moveShark();
        checkRemove();
    }

    private static void moveShark(){
        q = new LinkedList<>();
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                Shark shark = map[i][j];

                // 상어가 없으면 continue;
                if (shark == null) continue;

                int ss = shark.ss;
                int sd = shark.sd;
                int sz = shark.sz;

                int cnt = 0;
                int ny = i;
                int nx = j;

                if(sd == 1 || sd == 2){ // 상 하
                    ss %= (r -1) * 2;
                }else if(sd == 3 || sd == 4){ // 좌 우
                    ss %= (c -1) * 2;
                }

                while (cnt != shark.ss){
                    ny += dy[sd];
                    nx += dx[sd];

                    if(!outOfIdx(ny,nx)){
                        sd = changeD(sd); // 벽일때 이동방향
                        ny += 2*dy[sd];
                        nx += 2*dx[sd];
                        shark.sd = sd; // 이동방향 바꾸기
                    }
                    cnt++;
                }
                q.add(new Shark(ny, nx, ss, sd, sz));
            }
        }
    }

    private static void checkRemove() {
        map = new Shark[r + 1][c + 1];

        while (!q.isEmpty()) {
            Shark shark = q.poll();
            int y = shark.y;
            int x = shark.x;
            int s = shark.ss;
            int d = shark.sd;
            int z = shark.sz;

            if (map[y][x] == null) { // 이동한 위치에 이미 상어가 있다면
                map[y][x] = new Shark(y, x, s, d, z);
            } else {
                Shark preShark = map[y][x]; // 기존 상어
                if (preShark.sz < z) { // 기존 상어의 사이즈 보다 현재 이동한 상어의 사이즈가 더크면
                    map[y][x] = new Shark(y, x, s, d, z);
                }
            }
        }
    }
    private static boolean outOfIdx(int y, int x){
        if(y>0 && y<r+1 && x>0 && x<c+1){
            return true;
        }
        return false;
    }

    private static int changeD (int sd){
        // 1>2  2>1  3>4  4>3
        int d = 0;
        switch (sd){
            case 1:
                d = 2;
                break;
            case 2:
                d = 1;
                break;
            case 3:
                d = 4;
                break;
            case 4:
                d = 3;
                break;
        }
        return d;
    }
}