import java.io.*;
import java.util.*;

public class sw1249 {
  static boolean[][] visited;
  static int[][] time;
  static int[][] save;

  static int N;
  static int[] dx = { 0,0,-1,1 };
  static int[] dy = { -1,1,0,0 };
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int i=1; i<=T; i++){
      st = new StringTokenizer(bf.readLine());
      N = Integer.parseInt(st.nextToken());
      
      visited = new boolean[N][N];
      time = new int[N][N];
      save = new int[N][N];

      for(int j=0; j<N; j++){
        st = new StringTokenizer(bf.readLine());
        String t = st.nextToken();
        for(int k=0; k<N; k++){
          time[j][k] = Integer.parseInt(t.split("")[k]);
          save[j][k] = Integer.MAX_VALUE;
        }
      }
      save[0][0] = 0;
      save[N-1][N-1] = 0;
      bfs();

      System.out.println("#"+i+" " + save[N-1][N-1]);
    }
  }
  static public void bfs(){
    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[] {0,0});
    visited[0][0] = true;

    while(!queue.isEmpty()){
      int x = queue.peek()[0];
      int y = queue.peek()[1];
      queue.poll();
      for(int i=0; i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if(!visited[nx][ny] || save[x][y] + time[nx][ny] < save[nx][ny]){
          visited[nx][ny] = true;
          save[nx][ny] = save[x][y] + time[nx][ny];
          queue.add(new int[] {nx, ny});
        }
      }
    }

  }
}
