
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int[][] result;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < r; i++) {
			int option = Integer.parseInt(st.nextToken());
			switch (option) {
			case 1:
				op1();
				break;
			case 2:
				op2();
				break;
			case 3:
				op3();
				break;
			case 4:
				op4();
				break;
			case 5:
				op5();
				break;
			case 6:
				op6();
				break;
			}
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void op1() {
		result = new int[n][m];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[n - 1 - j][i] = arr[j][i];;
			}
		}
		arr = result;
	}

	public static void op2() {
		result = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][m - 1 - j] = arr[i][j];
			}
		}
		arr = result;
	}

	public static void op3() {
		
		result = new int[m][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[j][n - 1 - i] = arr[i][j];
			}
		}
		
		int tmp = n;
		n = m;
		m = tmp;
		
		arr = result;
	}

	public static void op4() {
		result = new int[m][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[m - 1 - j][i] = arr[i][j];
			}
		}
		
		int tmp = n;
		n = m;
		m = tmp;
		
		arr = result;
	}

	public static void op5() {
		result = new int[n][m];
		int[] dx = { 0, (n / 2), (n / 2), 0 };
		int[] dy = { 0, 0, (m / 2), (m / 2) };

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = arr[i][j];

				for (int k = 0; k < 3; k++) {
					result[i + dx[k]][j + dy[k]] = arr[i + dx[k + 1]][j + dy[k + 1]];
				}

				result[i + dx[3]][j + dy[3]] = temp;
			}
		}
		arr = result;
	}

	public static void op6() {
		result = new int[n][m];
		int[] dx = { 0, 0, (n / 2), (n / 2), 0 };
		int[] dy = { 0, (m/2), (m / 2), 0, (m / 2) };

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = arr[i][j];

				for (int k = 0; k < 3; k++) {
					result[i + dx[k]][j + dy[k]] = arr[i + dx[k + 1]][j + dy[k + 1]];
				}

				result[i + dx[3]][j + dy[3]] = temp;
			}
		}
		arr = result;
	}
}