
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken());

    for(int i=1; i<=T; i++){
      st = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(st.nextToken());

      System.out.println("#"+i+" " +N/3);
    }
    }
}