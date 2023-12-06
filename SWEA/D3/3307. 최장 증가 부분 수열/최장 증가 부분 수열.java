import java.io.*;
import java.util.*;

public class Solution {
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(bf.readLine());
			
			int[] arr = new int[n];
			int answer = 1;
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				
				
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[n];
			Arrays.fill(dp, 1);
			
			for(int i=1; i<n; i++) {
				for(int j=i; j>=0; j--) {
					if(arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
						answer = Math.max(answer, dp[i]);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}