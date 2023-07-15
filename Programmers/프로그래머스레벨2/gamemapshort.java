import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class gamemapshort {
    static int answer = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
  public static void main(String[] args) {
    int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    int[][] visit = new int[5][5];

    bfs(visit, maps);
    answer = visit[4][4];
    
    if(answer == 0){
        answer = -1;
    }
    System.out.println(answer);
  }
  static public void bfs(int[][] visit, int[][] maps){
    int x = 0;
    int y = 0;
    visit[x][y] = 1;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});

    while(!queue.isEmpty()){
      for(int i=0; i<5; i++){
        System.out.println((Arrays.toString(visit[i])));
      }
      
      int[] current = queue.remove();
      System.out.println(Arrays.toString(current));
      int cX = current[0];
      int cY = current[1];

      for(int i = 0; i < 4; i++){
        int nX = cX + dx[i];
        int nY = cY + dy[i];
        
        if(nX < 0 || nY < 0 || nX > 4 || nY > 4) continue;
        if(visit[nX][nY] == 0 && maps[nX][nY] == 1){
          visit[nX][nY] = visit[cX][cY] + 1;
          queue.add(new int[]{nX, nY});
        }
    }
  
    }
  }
}