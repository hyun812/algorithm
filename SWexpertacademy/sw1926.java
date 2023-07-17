import java.util.*;
import java.io.*;

public class sw1926 {
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N = Integer.parseInt(st.nextToken());

    for(int i=1; i<=N; i++){
      String target = Integer.toString(i);
      int count = 0;
      for(int j=0; j<target.length(); j++){
        if(target.split("")[j].equals("3") || target.split("")[j].equals("6") || target.split("")[j].equals("9")){
          count++;          
        }
      }
      
      if(count == 0) System.out.print(i);
      else{
        for(int j=0; j<count; j++){
          System.out.print("-");
        }
      }

      System.out.print(" ");
    }
  }
}
