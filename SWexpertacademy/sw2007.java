package SWExpectAcademy;

import java.util.*;
import java.io.*;

public class sw2007 {
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++){
      st = new StringTokenizer(bf.readLine());
      String target = st.nextToken();
      String madi = "";

      for(int j=0; j<target.length(); j++){
        madi += target.charAt(j);  
        int len = 30-(30%madi.length());
        
        if(target.substring(0, len).split(madi).length == 0){
          break;
        }
      }

      System.out.println("#" + (i+1) + " " + madi.length());
      
    }
    
  }
}
