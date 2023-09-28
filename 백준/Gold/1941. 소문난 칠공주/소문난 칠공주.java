import java.util.*;
import java.io.*;

public class Main {
    static String[][] arr;
    static int yCnt, sCnt;
    static int ans;
    static int[] checked;
    static boolean[] selected;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        arr = new String[5][5];
        checked = new int[7];
        selected = new boolean[25];
        
        for(int i=0; i<5; i++) {
            String s = bf.readLine();
            for(int j=0; j<5; j++) {
                arr[i][j] = s.split("")[j];
            }
        }
        
        comb(0, 0, 0);
        
        System.out.println(ans);
    }
    
    public static void comb(int cnt, int start, int yCnt) {
        if(cnt == 7) {
            if(yCnt >= 4) return;
            if(bfs()) {
                ans++;
            }
            return;
        }
        
        for(int i=start; i<25; i++) {
            int y = i/5;
            int x = i%5;
            
            checked[cnt] = i;
            selected[i] = true;
            if(arr[y][x].equals("Y")) {
                comb(cnt+1, i+1, yCnt+1);
            }else {
                comb(cnt+1, i+1, yCnt);
            }
            selected[i] = false;
        }
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    private static boolean bfs() {
    	int cnt = 1;
        boolean[] visited = new boolean[25];
        Queue<Integer> q = new LinkedList<>();
        q.add(checked[0]);;
        visited[checked[0]] = true;
        
        while(!q.isEmpty()) {
            int poll = q.poll();
            int y = poll/5;
            int x = poll%5;
            for(int d=0; d<4; d++) {
                int ny = y+dy[d];
                int nx = x+dx[d];
                
                if(!outOfIdx(ny, nx)) continue;
                if(visited[ny*5+nx]) continue;
                if(!selected[ny*5+nx]) continue;
                else {
                	cnt++;
                    q.add(ny*5+nx);
                    visited[ny*5+nx] = true;
                }
            }
        }
        return (cnt==7) ? true : false;
    }
    
    private static boolean outOfIdx(int y, int x) {
        if(y>=0 && y<5 && x>=0 && x<5){
            return true;
        }
        return false;
    }
}
