import java.util.Arrays;

public class dungeons {
  static public int answer = 0;
  static public boolean[] visit;
  public static void main(String[] args) {
    int[][] dungeons = {{80,20},{50,40},{30,10}};
    int k=80;

    visit = new boolean[dungeons.length];
        
    dfs(0, k, dungeons); //0은 depth, k 는 현재 피로도
    
    System.out.print(answer);
  }
  public static void dfs(int depth, int k, int[][]dungeons){
    for(int i = 0; i<dungeons.length; i++){
        if(!visit[i]&& dungeons[i][0]<=k){
            visit[i] = true;
            dfs(depth+1, k-dungeons[i][1], dungeons);
            visit[i] = false;
        }
    }
    answer = Math.max(answer, depth);
}
}
