
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
      long N = Long.parseLong(st.nextToken());

      long result = min(N);
       System.out.println("#" + (i+1) + " " + result);
    }

	}
    static public long min(long N){
    long result = N;
    for(int i=1; i<=Math.sqrt(N); i++){
      if(N%i ==0 ){
        long value = (N/i + i)-2;
        if(result > value){
          result = value;
        }
        
      }
    }
    return result;
  }
}