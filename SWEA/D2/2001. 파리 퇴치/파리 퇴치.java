
import java.util.*;
import java.io.*;

class Solution
{
      static int max = 0;
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++){
      st = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[][] arr = new int[N][N];
      for(int j=0; j<N; j++){
        st = new StringTokenizer(bf.readLine());
        for(int k=0; k<N; k++){
          arr[j][k] = Integer.parseInt(st.nextToken());
        }
      }
      for(int j=0; j<=N-M; j++){
        for(int k=0; k<=N-M; k++){
          check(arr, j, k, M);
        }
      }
      System.out.println("#" + (i+1) + " " + max); 
      max = 0;
    }
	}
     static public void check(int[][] arr, int x, int y, int M){
    int value = 0;
    for(int i=0; i<M; i++){
      for(int j=0; j<M; j++){
        value += arr[x+i][y+j] ;
      }
    }
    if(max < value){
      max = value;
    }
  }
}