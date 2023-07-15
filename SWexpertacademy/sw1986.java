package SWExpectAcademy;

import java.util.*;
import java.io.*;

public class sw1986 {
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int i=0; i<T; i++){
      st = new StringTokenizer(bf.readLine());
      int a = Integer.parseInt(st.nextToken());

      int result = 0;
      for(int j=1; j<=a; j++){
        if(j%2 == 0){
          result -= j;
        }else{
          result += j;
        }
      }
      System.out.println("#" + (i+1) + " " + result);
    }
  }
}
