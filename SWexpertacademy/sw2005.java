
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw2005 {
  static int[] arr = {1, 1};
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++){
      st = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(st.nextToken());
      
      System.out.println("#" + (i+1));
      
      for(int j=0; j<N; j++){
        print(j+1);
      }
    }
  }
  static public void print(int N){
    if(N == 1){
      System.out.println("1");
    }
    else if(N == 2){
      System.out.println("1 1");
    }
    else{
      int[] array = new int[N];    
      for(int i=0; i<array.length; i++){
        if(i == 0 || i == array.length-1){
          array[i] = 1;
          System.out.print(array[i] + " ");
        }else{
          array[i] = arr[i-1]+arr[i];
          System.out.print(array[i] + " ");
        }
      }
      System.out.println();
      arr = array;
    }
  }
}
