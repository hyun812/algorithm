import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static String[][] arr;
	static ArrayList<int[]> Tlist, Slist;
	static int block;

	static String answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		arr = new String[n][n];
		Tlist = new ArrayList<int[]>();
		Slist = new ArrayList<int[]>();
		answer = "NO";
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = st.nextToken();

				if (arr[i][j].equals("X")) {
					continue;
				}
				// 만약 선생님이라면
				else if (arr[i][j].equals("T")) {
					Tlist.add(new int[] { i, j });
				}
				// 만약 학생이라면
				else if (arr[i][j].equals("S")) {
					Slist.add(new int[] { i, j });
				}
			}
		}

		String[][] copy = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = arr[i][j];
			}
		}

		comb(0, 0, copy);
		System.out.println(answer);
	}

	// X중에서 3개 고르기
	private static void comb(int cnt, int start, String[][] copy) {
		if (answer.equals("YES"))
			return;
		if (cnt == 3) {
			// 볼 수 있는지 확인
			if (check(copy)) {
				answer = "YES";
			}
			return;

		}

		for (int i = start; i < n * n; i++) {
			int y = i / n;
			int x = i % n;

			if (!arr[y][x].equals("X"))
				continue;

			copy[y][x] = "B";
			comb(cnt + 1, i + 1, copy);
			copy[y][x] = "X";
		}
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	private static boolean check(String[][] copy) {
		for (int[] s : Slist) {
			int y = s[0];
			int x = s[1];

			for (int i = 0; i < 4; i++) {
				int range = 1;
				while (true) {
					int ny = y + dy[i] * range;
					int nx = x + dx[i] * range;

					if (!outOfIdx(ny, nx))
						break;
					if(copy[ny][nx].equals("B")) {
						break;
					}
					if (copy[ny][nx].equals("T")) {
						return false;
					}
					
					range++;
				}
			}
		}
		return true;
	}

	private static boolean outOfIdx(int ny, int nx) {
		if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
			return true;
		}
		return false;
	}
}