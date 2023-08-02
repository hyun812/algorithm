import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int i=0; i<T; i++){
      String[][] rook = new String[8][8];
      for(int j=0; j<8; j++){
        st = new StringTokenizer(bf.readLine());
        rook[j] = st.nextToken().split("");
        
      }
      if(checkRook(rook)){
        System.out.println("#"+(i+1)+" yes");
      }else{
        System.out.println("#"+(i+1)+" no");
      }
    }
		
	}
     static public boolean checkRook(String[][] line){
    int count = 0;
    for(int i=0; i<8; i++){
      for(int j=0; j<8; j++){
        if(line[i][j].equals("O")){
          count++;
            if(Collections.frequency(Arrays.asList(line[i]), "O")>= 2){
            return false;
          }
            
          for(int k=0; k<8; k++){
            if(k == i) continue;
            if(line[k][j].equals("O")){
              return false;
            }
          }
        }
      }
    }
         if(count != 8) return false;
    return true;
  }
}