import java.io.*;
import java.util.*;

public class Main {
	static int n, l;
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			if(rowCheck(i))
				ans++;
			if(colCheck(i))
				ans++;
		}
		
		System.out.println(ans);
	}

	private static boolean rowCheck(int y) {
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n - 1; i++) {
			int diff = arr[y][i] - arr[y][i+1]; // 차이

			if (diff == 0)
				continue;
			if (diff == 1) { // 내려가는거
				for (int j = i + 1; j <= i + l; j++) {
					if (j >= n)
						return false; // 범위 벗어나거나
					if (visited[j])
						return false; // 방문했던적이 있거나
					if (arr[y][i+1] != arr[y][j])
						return false; // 서로 다르면

					visited[j] = true;
				}
			} else if (diff == -1) { // 올라가는거
				for (int j = i; j >= i - l + 1; j--) {
					if (j < 0)
						return false; // 범위 벗어나거나
					if (visited[j])
						return false; // 방문했던적이 있거나
					if (arr[y][i] != arr[y][j])
						return false; // 서로 다르면

					visited[j] = true;
				}
			} else {
				return false; // 차이가 2이상 나면
			}
		}
		return true;
	}

	private static boolean colCheck(int x) {
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n - 1; i++) {
			int diff = arr[i][x] - arr[i + 1][x]; // 차이

			if (diff == 0)
				continue;
			if (diff == 1) { // 내려가는거
				for (int j = i + 1; j <= i + l; j++) {
					if (j >= n)
						return false; // 범위 벗어나거나
					if (visited[j])
						return false; // 방문했던적이 있거나
					if (arr[i+1][x] != arr[j][x])
						return false; // 서로 다르면

					visited[j] = true;
				}
			} else if (diff == -1) { // 올라가는거
				for (int j = i; j >= i - l + 1; j--) {
					if (j < 0)
						return false; // 범위 벗어나거나
					if (visited[j])
						return false; // 방문했던적이 있거나
					if (arr[i][x] != arr[j][x])
						return false; // 서로 다르면

					visited[j] = true;
				}
			} else {
				return false; // 차이가 2이상 나면
			}
		}
		return true;
	}
}