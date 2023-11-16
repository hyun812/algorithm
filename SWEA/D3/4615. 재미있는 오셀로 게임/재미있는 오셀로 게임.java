import java.io.*;
import java.util.*;

public class Solution {
	static int n, m;
	static int[][] arr;
	static int ansB, ansW;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bf.readLine());

			n = Integer.parseInt(st.nextToken()); // 한변의 길이
			m = Integer.parseInt(st.nextToken()); // 돌을 놓는 횟수

			arr = new int[n][n];
			ansB = ansW = 0;

			// 초기 세팅
			int temp = (n / 2) - 1;
			arr[temp][temp] = 2;
			arr[temp][temp + 1] = 1;
			arr[temp + 1][temp] = 1;
			arr[temp + 1][temp + 1] = 2;

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(bf.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int type = Integer.parseInt(st.nextToken()); // 1이면 흑, 2 이면 백

				doit(y, x, type);

			}

			checkBW();
			sb.append("#").append(tc).append(" ").append(ansB).append(" ").append(ansW).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };

	private static void doit(int y, int x, int type) {
		// 입력 받은 자리에 돌 놓기
		arr[y][x] = type;

		// 8방향 탐색
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			// 범위 벗어나면
			if (!outOfIdx(ny, nx))
				continue;
			// 해당 자리가 0이라면
			if (arr[ny][nx] == 0)
				continue;
			if (arr[ny][nx] == type)
				continue;

			// 해당 자리가 다른 색깔이라면 끝까지 이동하면서 확인하기
			ArrayList<int[]> list = new ArrayList<>();
			boolean flag = false;
			int nny = y;
			int nnx = x;
			while (true) {
				nny += dy[i];
				nnx += dx[i];

				if (!outOfIdx(nny, nnx))
					break;
				if (arr[nny][nnx] == 0)
					break;
				if (arr[nny][nnx] == type) {
					flag = true;
					break;
				}
				// 바꿔야 되는 돌이면
				else if (arr[nny][nnx] != type) {
					list.add(new int[] { nny, nnx });
				}
			}


			// 해당 자리 돌 뒤집기
			if (flag) {
				for (int j = 0; j < list.size(); j++) {
					int[] target = list.get(j);
					arr[target[0]][target[1]] = type;
				}
			}
		}

	}

	private static void checkBW() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					ansB++;
				} else if (arr[i][j] == 2) {
					ansW++;
				}
			}
		}

	}

	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
			return true;
		}
		return false;
	}

}