import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(bf.readLine());

		Arrays.sort(arr);

		int answer = 0;
		int left = 0;
		int right = n - 1;

		while (left < right) {
			int sum = arr[left] + arr[right];

			if (sum == x) {
				answer++;
			}

			if (sum <= x) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(answer);
	}
}