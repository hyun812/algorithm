import java.util.*;
import java.io.*;

public class Main {
    static int r,c,t;
    static int[][] arr;
    static Queue<dus> q;
    static int[] fair, sair;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        
        arr = new int[r][c];
        
        int cnt = 0; // 공기청정기를 구분하기 위한 cnt변수
        
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) { // 공기청정기 이면
                    if(cnt == 0) { // 처음만난 공기청정기 이면
                        fair = new int[] {i, j};
                        cnt++;
                    }else if(cnt == 1) {
                        sair = new int[] {i, j};
                    }
                }
            }
        }

        // 다음을 t초만큼 반복
        for(int i=0; i<t; i++) {
            checkDust();
            diffusion();
            startAir();
            
        }
        
        int ans = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                ans += arr[i][j];
            }
        }
        System.out.println(ans+2);
        
    }
    // 미세먼지 확인
    private static void checkDust() {
        q = new LinkedList<>();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
            	if(arr[i][j] == -1) continue;
            	if(arr[i][j] == 0) continue;
                q.add(new dus(i,j,arr[i][j]));
            }
        }
    }
    
    // 미세먼지 확산
    private static void diffusion() {
                
        while(!q.isEmpty()) {
        	dus poll = q.poll();
            int y = poll.y;
            int x = poll.x;
            int dust = poll.size;

            if(dust < 5) continue; // 5보다 작으면 확산하지 않으므로
            
            int cnt = 0; // 4방향 중 몇개의 칸에 확산 시킬 수 있는 지 확인하기 위한 변수
            for(int i=0; i<4; i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                
                if(!outOfIdx(ny, nx)) continue; // 인덱스를 벗어났으면
                if(arr[ny][nx] == -1) continue; // 공기청정기를 만났으면
                
                cnt++;
                arr[ny][nx] += dust/5;
            }

            // 원래있던 값 - (확산된방향의 개수 * 확산되는 양)
            arr[y][x] -= cnt*(dust/5);
        }
    }
    
    //    공기청정기 작동
    private static void startAir() {

        // 위쪽 공기청정기 순환시키기 ( 반시계 방향 )
        int fy = fair[0]; // 위쪽 공기청정기 y좌표
        int fx = fair[1]; // 위쪽 공기청정기 x좌표
        int[] ry = {-1, 0, 1, 0};
        int[] rx = {0, 1, 0, -1};
        
        int idx = 0; // 방향 지정을 위한 idx
        int y = fy-1;
        int x = 0;
        
        //배열 돌리는 코드 작성
        while(true) {
            if(idx >= 4) break;
            
            int ny = y+ry[idx];
            int nx = x+rx[idx];
            
            // 범위 벗어나면
            if(!outOfIdx(ny, nx) || ny > fy) {
                idx++;
                continue;
            }
            
            arr[y][x] = arr[ny][nx];
            y = ny;
            x = nx;
        }
        arr[fy][fx+1] = 0;
        
        // 아래쪽 공기청정기 순환시키기 ( 시계 방향 )
        int sy = sair[0]; // 위쪽 공기청정기 y좌표
        int sx = sair[1]; // 위쪽 공기청정기 x좌표
        ry = new int [] {1, 0, -1, 0};
        rx = new int [] {0, 1, 0, -1};
        
        idx = 0; // 방향 지정을 위한 idx
        y = sy+1;
        x = 0;
        //배열 돌리는 코드 작성
        while(true) {
            if(idx >= 4) break;
            
            int ny = y+ry[idx];
            int nx = x+rx[idx];
            
            // 범위 벗어나면
            if(!outOfIdx(ny, nx) || ny < sy) {
                idx++;
                continue;
            }
            
            arr[y][x] = arr[ny][nx];
            y = ny;
            x = nx;
        }
        arr[sy][sx+1] = 0;
    }
    
    // 인덱스 확인
    private static boolean outOfIdx(int ny, int nx) {
        if(ny>=0 && ny<r && nx>=0 && nx<c) {
            return true;
        }
        return false;
    }
    
    static class dus {
    	int y,x,size;

		public dus(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
		}
    }
}