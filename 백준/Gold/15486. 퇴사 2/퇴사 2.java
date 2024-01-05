import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] tArr, pArr;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine());
		tArr = new int[n+2];
		pArr = new int[n+2];
		// N일 동안 최대한많은 상담 진행
		// T는 상담을 완료하는데 걸리는 기간
		// P는 이때 받을 수 있는 금액
		// 얻을 수 있는 최대 수익
		for(int i=1; i<=n; i++) {
			st  = new StringTokenizer(bf.readLine());
			tArr[i] = Integer.parseInt(st.nextToken());
			pArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+2];
		int max = -1;
		for(int i=1; i<=n+1; i++) {
			max = Math.max(max, dp[i]);
			
			// 해당 일자 상담을 받은 후, 다음에 상담을 받을 수 있는 날짜
			int next = i + tArr[i];
			
			if(next > n+1) { // 범위 넘어서면
				continue;
			} 
				
			dp[next] = Math.max(dp[next], max + pArr[i]);
		}
		/* 
		 * 1일 
		 * 2일 
		 * 
		 * 
		 * 
		 * */
		System.out.println(max);
	}
}