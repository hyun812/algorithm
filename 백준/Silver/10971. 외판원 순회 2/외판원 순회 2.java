
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean[] check;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static int start = 0; 

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		check = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			check[i] = true;
			start = i;
			com(i, 1, arr[0][i]);
			check[i] = false;
		}

		System.out.println(min);
	}

	public static void com(int res, int cnt, int sum) {
		if (cnt == n) {
			if(arr[res][start] !=0) {
				sum += arr[res][start];
				min = (sum < min) ? sum : min;	
			}
			
			return;
		}

		for (int j = 0; j < n; j++) {
			if (arr[res][j] != 0 && !check[j]) {
				check[j] = true;
				com(j, cnt + 1, sum + arr[res][j]);
				check[j] = false;
			}
		}

	}
}
