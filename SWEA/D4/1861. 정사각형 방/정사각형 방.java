
import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int n;
	static int[][] cnt;
	static int resultcnt;
	static int resultpos;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			resultcnt = -1;
			resultpos = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					check(i, j, 1);
					
				}
			}

			sb.append("#").append(tc).append(" ").append(resultpos).append(" ").append(resultcnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static int check(int sty, int stx, int cnt) {
		for (int i = 0; i < 4; i++) {
			int ny = sty + dy[i];
			int nx = stx + dx[i];

			if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
				if (arr[ny][nx] == arr[sty][stx] + 1) {
					cnt = check(ny, nx, cnt + 1);
					
					if (resultcnt < cnt) {
						resultcnt = cnt;
						resultpos = arr[sty][stx];
					} else if (resultcnt == cnt) {
						if (resultpos > arr[sty][stx]) {
							resultpos = arr[sty][stx];
						}
					}
					
					break;
				}
			}
		}
		
		return cnt;

	}
}
