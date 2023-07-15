import java.io.*;
import java.util.*;

public class sw17299 {
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int i=1; i<=T; i++){
      st = new StringTokenizer(bf.readLine());
      String N = st.nextToken();

      int result = minN(N);

      System.out.println("#"+i+" " + result);
    }
  }
  static public int minN(String N){
    int result = Integer.parseInt(N);

    for(int i=1; i<N.length(); i++){
      int a = Integer.parseInt(N.substring(0, i));
      int b = Integer.parseInt(N.substring(i));

      if(result > a+b){
        result = a+b;
      }
    }
    return result;
  }
}
