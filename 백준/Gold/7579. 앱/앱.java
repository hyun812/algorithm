import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] mArr, cArr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 현재 활성화 되어 있는 앱의 개수
		m = Integer.parseInt(st.nextToken()); // 확보해야할 메모리

		mArr = new int[n];
		cArr = new int[n];
		answer = Integer.MAX_VALUE;
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			cArr[i] = Integer.parseInt(st.nextToken());
		}

		// 값은 사용한 메모리 바이트
		// 몇번째 까지 비활성화 할지
		// 비용
		// dp[0][3] = 30
		int[][] dp = new int[n][100001];

		for (int i = 0; i < n; i++) {
			int memory = mArr[i];
			int cost = cArr[i];

			for (int j = 0; j < 100001; j++) {
				if (i == 0) {
					if (j >= cost)
						dp[i][j] = memory;
				}

				else {
					if (j >= cost) {
						dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
				
				if (dp[i][j] >= m) {
					answer = Math.min(answer, j);
				}
			}
		}

		// 필요한 메모리를 확보하기 위한 최소 비용 파악
		System.out.println(answer);

	}

}