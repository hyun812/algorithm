public class targetnumber {
  static public int target = 0;
  static public int answer = 0;
  public static void main(String[] args) {
    int[] numbers = {1,1,1,1,1};
    target = 3;

    bfs(0, 0, numbers);
    System.out.println(answer);
  }  

  public static void bfs(int sum, int index, int[] numbers){
      if(index == numbers.length){
        if(sum == target) answer++;
      }
      else {
        bfs(sum+numbers[index], index+1, numbers);
        bfs(sum-numbers[index], index+1, numbers);
      }
    
  }
}
