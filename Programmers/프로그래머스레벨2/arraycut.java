import java.util.Arrays;

public class arraycut {
  public static void main(String[] args) {
    int n = 4;
    int left = 7;
    int right = 14;

    // int[][] tmp = new int[n][n];

    // for(int i=0; i<n; i++){
    //   for(int j=0; j<n; j++){
    //     tmp[i][j] = Math.max(i+1, j+1);
    //   }
    // }
    // (int) (left / (long) n);
    // (int) (left / (long) n);
    int[] answer = new int[right-left+1];

    
    for(int i=0; i<answer.length; i++){
      int x = left/n +1;
      int y = left%n +1;
      left++;
      answer[i] = Math.max(x, y);
    }

    System.out.println(Arrays.toString(answer));
  }
}
