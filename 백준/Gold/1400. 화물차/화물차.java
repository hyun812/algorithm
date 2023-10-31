import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static String[][] arr;
    static int startY, startX, endY, endX;
    static String regExp = "^[0-9]+$";
    static ArrayList<cross> crossList;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while(true) {
        	st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            if(n ==0 && m == 0) break;
            
            arr = new String[n][m];
            int maxCross = 0;
            ArrayList<int[]> list = new ArrayList<>();
            crossList = new ArrayList<>();
            ans = 0;
            
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(bf.readLine());
                String[] s = st.nextToken().split("");
                for(int j=0; j<m; j++) {
                    arr[i][j] = s[j];
                    
                    if(arr[i][j].matches(regExp)){
                        list.add(new int[] {i, j});
                        maxCross = Math.max(maxCross, Integer.parseInt(arr[i][j]));
                    }else if("A".equals(arr[i][j])){
                        startY = i;
                        startX = j;
                    }else if("B".equals(arr[i][j])){
                        endY = i;
                        endX = j;
                    }
                }
            }
            
            for(int i=0; i<list.size(); i++) {
                st = new StringTokenizer(bf.readLine());
                
                int idx = Integer.parseInt(st.nextToken());
                String startPos = st.nextToken();
                int lrTime = Integer.parseInt(st.nextToken());
                int tbTime = Integer.parseInt(st.nextToken());
                
                crossList.add(new cross(list.get(i)[0], list.get(i)[1], startPos, lrTime, tbTime));
            }
            
            bfs();
            
            if(ans == 0) {
            	sb.append("impossible").append("\n");
            }else {
            	sb.append(ans).append("\n");	
            }
            bf.readLine();
        }
        System.out.println(sb.toString());
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    private static void bfs() {
        Queue<car> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new car(startY, startX, 0));
        visited[startY][startX] = true;
        
        while(!q.isEmpty()) {
            car c = q.poll();
            int y = c.y;
            int x = c.x;
            int time = c.time;
            
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                // 도착했다면 return
                if(ny==endY && nx==endX) {
                    ans = time+1;
                    return;
                }
                
                if(!outOfIdx(ny, nx)) continue;
                if(visited[ny][nx]) continue;
                if(".".equals(arr[ny][nx])) continue;

                // 교차로를 만났다면
                if(arr[ny][nx].matches(regExp)) {
                    int idx = Integer.parseInt(arr[ny][nx]);
                    cross cro = crossList.get(idx);
                    boolean posCheck = nPos(time+1, cro, ny, nx);
                    
                    // 지나갈 수 있음
                    if(moveCheck(i, cro.startPos, posCheck)) {
                        q.add(new car(ny, nx, time+1));
                        visited[ny][nx] = true;
                    }else {
                        q.add(new car(y, x, time+1));
                    }
                }else { // 일반 도로이면
                    q.add(new car(ny, nx, time+1));
                    visited[ny][nx] = true;
                }
            }
        }
    }
    
    

    static boolean moveCheck(int idx, String pos, boolean posCheck) {
        String nPos = pos;
        
        if(!posCheck) {
            if("-".equals(nPos)) {
                nPos = "|";
            }else {
                nPos = "-";
            }
        }
        
        if("-".equals(nPos)) {
            if(idx == 2 || idx == 3) {
                return true;
            }
        }else {
            if(idx == 0 || idx == 1) {
                return true;
            }
        }
        
        return false;
    }
    
    // 현재 방향 어떻게 돼있는지
    // true면 기존과 동일 false면 반대
    static boolean nPos(int time, cross cro, int ny, int nx) {
        String startPos = cro.startPos; // 초기 방향
        int start = 0;
       
        boolean flag = true;
        // 동서 2 4
        // 1~2 3~6 7~8
        // 동서 방향 이면
        if("-".equals(startPos)) {
    	   while(time > start) {
               if(flag) {
                   start += cro.lrTime;
                   flag = !flag;
               }else {
                   start += cro.tbTime;
                   flag = !flag;
               }
           }
           return !flag;
        }else { // 남북 방향이면
            while(time > start) {
                if(flag) {
                    start += cro.tbTime;
                    flag = !flag;
                }else {
                    start += cro.lrTime;
                    flag = !flag;
                }
            }
            return !flag;
        }
    }
    
    static boolean outOfIdx(int ny, int nx) {
        if(ny>=0 && ny<n && nx>=0 && nx<m) {
            return true;
        }
        return false;
    }
    
    static class car {
        int y, x, time;

        public car(int y, int x, int time) {
            super();
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
    
    static class cross{
        int y, x;
        String startPos;
        int lrTime, tbTime;

        public cross(int y, int x, String startPos, int lrTime, int tbTime) {
            super();
            this.y = y;
            this.x = x;
            this.startPos = startPos;
            this.lrTime = lrTime;
            this.tbTime = tbTime;
        }
    }
}