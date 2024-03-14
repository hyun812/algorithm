import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		arr = new int[n][3];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n][3];

		for (int c = 0; c < 3; c++) { // 처음 시작하는 색깔

			for (int i = 0; i < 3; i++) { // 처음 선택하는 색깔이 아니면 최대로 설정함으로써 확인
				if (i == c)
					dp[0][i] = arr[0][i];
				else
					dp[0][i] = 1000 * 1000;
			}

			for (int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
			}

			for (int i = 0; i < 3; i++) {
				if (i != c) { // 처음과 다른 색깔을 선택했다면
					answer = Math.min(answer, dp[n - 1][i]);
				}
			}
		}

		System.out.println(answer);
	}

}