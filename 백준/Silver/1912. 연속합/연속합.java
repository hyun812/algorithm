import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr, dp;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		
		arr = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dp[0] = arr[0];
		answer = arr[0];
		
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			answer = Math.max(dp[i], answer);
		}
		
		System.out.println(answer);
	}
}