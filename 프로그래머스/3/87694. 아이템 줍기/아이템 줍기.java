import java.util.*;

class Solution {
    static int[][] arr;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        arr = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        Queue<Node> q = new ArrayDeque<>();
        
        int answer = 0;
        
        // 좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y
        for(int i=0; i<rectangle.length; i++){
            int bx = rectangle[i][0];
            int by = rectangle[i][1];
            int tx = rectangle[i][2];
            int ty = rectangle[i][3];
            
            draw(bx*2, by*2, tx*2, ty*2);
        }
        
        
        q.add(new Node (characterX*2, characterY*2, 0));
        
        while(!q.isEmpty()){
            Node poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            int len = poll.len;
            
            if(x == itemX*2 && y == itemY*2){
                return len/2;
            }
            
            // 상하좌우 확인
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || ny<0 || nx>=101 || ny>= 101) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] != 2) continue;
                
                q.add(new Node(nx, ny, len+1));
                visited[nx][ny] = true;
                
            }
        }
        
        return answer;
    }
    
    public static void draw(int bx, int by, int tx, int ty){
        for(int i=bx; i<=tx; i++){
            for(int j=by; j<=ty; j++){
                if(arr[i][j] == 1) continue;
                arr[i][j] = 1;
                if(i==bx || i==tx || j==by || j==ty){
                    arr[i][j] = 2;
                }
            }
        }
    }
    
    
    static class Node {
        int x,y, len;
        
        public Node(int x, int y, int len){
            super();
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}