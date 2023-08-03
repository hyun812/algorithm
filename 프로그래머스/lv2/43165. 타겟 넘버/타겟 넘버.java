class Solution {
    static public int tar = 0;
    static public int answer = 0;
    public int solution(int[] numbers, int target) {
        tar = target;
        bfs(0, 0, numbers);
        return answer;
    }
    public static void bfs(int sum, int index, int[] numbers){
      if(index == numbers.length){
        if(sum == tar) answer++;
      }
      else {
        bfs(sum+numbers[index], index+1, numbers);
        bfs(sum-numbers[index], index+1, numbers);
      }
    
  }
}