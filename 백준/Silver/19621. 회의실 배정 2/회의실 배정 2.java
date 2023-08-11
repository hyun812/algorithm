
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int peo = Integer.parseInt(st.nextToken());
			
			arr[i] = peo;
		}

		dp[0] = arr[0];
		if(n != 1) {
			dp[1] = Math.max(arr[0], arr[1]);	
		}
		
		for(int i=2; i<n; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
		}
		

		System.out.println(dp[n-1]);

	}

}
