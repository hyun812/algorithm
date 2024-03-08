import java.io.*;
import java.util.*;

public class Main {
	static int m, n;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());

		m = Integer.parseInt(st.nextToken()); // 조카의 수
		n = Integer.parseInt(st.nextToken()); // 과자의 수

		arr = new int[n];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 1;
		int right = arr[n - 1];
		int mid = 0;

		while (left <= right) {
			int cnt = 0;
			mid = (left + right) / 2;

			for (int i = 0; i < n; i++) {
				cnt += arr[i] / mid;
			}

			if (m <= cnt) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

//		System.out.println(left);
//		System.out.println(mid);
		System.out.println(right);

	}
}