import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[][] arr;
	static int[][] hole;
	static int ans;

	public static void main(String[] args) throws Exception {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();

			arr = new int[n][n];
			hole = new int[11][2];
			ans = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
//				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();

					if (arr[i][j] >= 6) {
						if (hole[arr[i][j]][0] == 0) {
							hole[arr[i][j]][0] = i * n + j;
						} else {
							hole[arr[i][j]][1] = i * n + j;
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0)
						continue;
					doit(i, j);
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb.toString());
	}

	// 출발 위치와 임의 방향을 지정할 수 있
	static int[] dy = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dx = { 0, 0, -1, 1 };

	private static void doit(int y, int x) {

		// 4방향 중 한방향 선택해서 게임시작
		for (int i = 0; i < 4; i++) {

			int count = 0;
			int dis = i;
			int ny = y + dy[i];
			int nx = x + dx[i];
			while (true) {
				if (!outOfIdx(ny, nx)) { // 범위 벗어났으면 방향 반대로 해주고 +1
					dis = reverseDis(dis);
					ny += dy[dis];
					nx += dx[dis];
					count++;
				}
				if (ny == y && nx == x)
					break; // 시작위치로 왔으면
				if (arr[ny][nx] == -1)
					break; // 블랙홀을 만났으면

				if (arr[ny][nx] == 0) {
					ny += dy[dis];
					nx += dx[dis];
				} else if (arr[ny][nx] >= 1 && arr[ny][nx] <= 5) { // 블록 만났을 때
					dis = getBlockDis(dis, arr[ny][nx]);
					ny += dy[dis];
					nx += dx[dis];
					count++;
				} else { // 웜홀 만났으면
					if (hole[arr[ny][nx]][0] / n == ny && hole[arr[ny][nx]][0] % n == nx) {
						int temp = hole[arr[ny][nx]][1];
						ny = (temp / n) + dy[dis];
						nx = (temp % n) + dx[dis];
					} else {
						int temp = hole[arr[ny][nx]][0];
						ny = (temp / n) + dy[dis];
						nx = (temp % n) + dx[dis];
					}
				}
			}
			ans = Math.max(ans, count);
		}
	}

	private static int getBlockDis(int d, int num) {
		int ans = -1;
		if (d == 0) {
			if (num == 2) {
				ans = 3;
			} else if (num == 3) {
				ans = 2;
			}
		} else if (d == 1) {
			if (num == 1) {
				ans = 3;
			} else if (num == 4) {
				ans = 2;
			}
		} else if (d == 2) {
			if (num == 1) {
				ans = 0;
			} else if (num == 2) {
				ans = 1;
			}
		} else if (d == 3) {
			if (num == 3) {
				ans = 1;
			} else if (num == 4) {
				ans = 0;
			}
		}

		if (ans == -1) {
			ans = reverseDis(d);
		}
		return ans;
	}

	private static int reverseDis(int d) {
		int ans = 0;
		switch (d) {
		case 0:
			ans = 1;
			break;
		case 1:
			ans = 0;
			break;
		case 2:
			ans = 3;
			break;
		case 3:
			ans = 2;
			break;
		}
		return ans;
	}

	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
			return true;
		}
		return false;
	}
}