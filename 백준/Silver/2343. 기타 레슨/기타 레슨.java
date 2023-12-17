import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken()); // 강의의 수
		m = Integer.parseInt(st.nextToken()); // 블루레이 개수

		arr = new int[n];
		answer = 0;

		// start와 end는 각 블루레이의 크기를 정하기 위함
		int start = 0;
		int end = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end += arr[i];
			start = Math.max(start, arr[i]);
		}

		int mid = 0;
		// 45 + 9 /2 = 27

		while (start < end) {
			mid = (start + end) / 2; // 블루레이의 크기

			int sum = 0;
			int cnt = 1;
			for (int i = 0; i < n; i++) {
				sum += arr[i];
				if (sum > mid) {
					sum = arr[i];
					cnt++;
				}
			}
			if (cnt > m) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		System.out.println(end);
	}

}