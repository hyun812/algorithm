
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
      st = new StringTokenizer(bf.readLine());
      String word = st.nextToken();

      if(check(word)){
        System.out.println("#" + (i+1) + " " + 1);
      }else{
        System.out.println("#" + (i+1) + " " + 0);
      }
      
    }
		
	}
    static public boolean check(String word){
    for(int j=0; j<word.length(); j++){
      if(word.charAt(j) != word.charAt(word.length()-1-j)){
        return false;
      }
    }
    return true;
  }
}