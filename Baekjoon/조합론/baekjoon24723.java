package 조합론;

import java.util.*
;
public class baekjoon24723 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int result = 1;

    for(int i=0; i<N; i++){
      result *= 2;
    }

    System.out.println(result);
  }
}
