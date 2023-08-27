import java.io.*;
import java.util.*;

public class Solution {
    static int[][] arr;
    static int[][] visited;
    static int n,m,r,c,l;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());

        for(int tc=1; tc<=t; tc++){
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            ans = 1;
            arr = new int[n][m];
            visited = new int[n][m];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<m; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(l == 1){
                System.out.println("#"+tc+" "+ans);
            }else{
                dfs();
                System.out.println("#"+tc+" "+ans);
            }

        }
    }

    private static void dfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = 1;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            int target = arr[y][x];

            dirRotate(target);
            for(int i=0; i<dx.length; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(!outofidx(ny, nx)) continue;
                if(visited[ny][nx] != 0) continue;

                int ntar = arr[ny][nx];

                if(ntar != 0 && check(dy[i], dx[i], ntar)){
                    visited[ny][nx] = visited[y][x] +1;
                    ans++;
                    if(visited[ny][nx] == l) continue;

                    q.add(new int[] {ny, nx});
                }
            }
        }
    }

    private static boolean check(int dy1, int dx1, int ntar){
        if(ntar == 1) return true;
        if(dy1 == -1 && dx1 == 0){ // 위
            if(ntar == 2 || ntar == 5 || ntar == 6){
                return true;
            }
        }else if(dy1 == 1 && dx1 == 0){ // 아래
            if(ntar == 2 || ntar == 4 || ntar == 7){
                return true;
            }
        }else if(dy1 == 0 && dx1 == -1){ // 왼쪽
            if(ntar == 3 || ntar == 4 || ntar == 5){
                return true;
            }
        }else if(dy1 == 0 && dx1 == 1){ // 오른쪽
            if(ntar == 3 || ntar == 6 || ntar == 7){
                return true;
            }
        }
        return false;
    }
    // 0이아니고 범위 벗어나지않고
    // 갈수 있는 길이면
    // 1이면 위에는 2,5,6 올 수 있음
    //      아래에는 2,4,7 올 수 있음
    //      왼쪽에는 3,4,5 올 수 있음
    //      오른쪽에는 3,6,7 올 수 있음

    // 2이면 위에는 2,5,6
    //      아래에는 2,4,7

    // 3이면 왼쪽에는 3,4,5
//          오른쪽에는 3,6,7

    static int[] dy;
    static int[] dx;
    private static void dirRotate(int target) {
        switch (target){
            case 1 :
                dy = new int[] {-1, 1, 0, 0};
                dx = new int[] {0, 0, -1, 1};
                break;
            case 2 :
                dy = new int[] {-1, 1};
                dx = new int[] {0, 0};
                break;
            case 3 :
                dy = new int[] {0, 0};
                dx = new int[] {-1, 1};
                break;
            case 4 :
                dy = new int[] {-1, 0};
                dx = new int[] {0, 1};
                break;
            case 5 :
                dy = new int[] {1, 0};
                dx = new int[] {0, 1};
                break;
            case 6 :
                dy = new int[] {1, 0};
                dx = new int[] {0, -1};
                break;
            case 7 :
                dy = new int[] {-1, 0};
                dx = new int[] {0, -1};
                break;
        }
    }

    private static boolean outofidx(int y, int x){
        if(y >=0 && y<n && x>=0 && x<m){
            return true;
        }
        return false;
    }
}

//5 6 2 1 3
//0 0 5 3 6 0
//0 0 2 0 2 0
//3 3 1 3 7 0
//0 0 0 0 0 0
//0 0 0 0 0 0