import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static boolean[][] dp;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());

		arr = new int[n + 1];
		dp = new boolean[n + 1][n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		doit();
		
		m = Integer.parseInt(bf.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(dp[start][end]) {
				sb.append("1").append("\n");
			}else {
				sb.append("0").append("\n");	
			}
			
		}

		System.out.println(sb.toString());
	}

	private static void doit() {
		// 길이가 1이면 모두 true
		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;
		}

		// 길이가 2일때는 두개가 같으면 true
		for (int i = 1; i <= n - 1; i++) {
			if (arr[i] == arr[i + 1])
				dp[i][i + 1] = true;
		}

		// 길이가 3이상이라면 (시작+1 ~ 끝-1 이 true) && (시작과 끝이 같으면) true
		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}
		}
	}

	
}