package SWExpectAcademy;

import java.util.*;
import java.io.*;

public class sw16910 {
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int i=0; i<T; i++){
      st = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(st.nextToken());

       int count = 0;
       for(int j=1; j<=N; j++){
         for(int k=1; k<=N; k++){
           if((k*k) + (j*j) <= N*N){
             count++;
           }
         }
         
        }
        count = (count*4) + (N*4) + 1;
      System.out.println("#" + (i+1) + " " + count);
    
    }
  }
}
