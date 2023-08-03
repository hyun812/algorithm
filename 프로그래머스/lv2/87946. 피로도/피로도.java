class Solution {
    static public boolean[] visit;
      static public int answer = 0;
    public int solution(int k, int[][] dungeons) {
        
        visit = new boolean[dungeons.length];
        
    dfs(0, k, dungeons); //0은 depth, k 는 현재 피로도
        return answer;
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