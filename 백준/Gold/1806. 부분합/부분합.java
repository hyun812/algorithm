import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int sum = arr[0];
		int len = 1;
		int answer = Integer.MAX_VALUE;

		while (left <= n - 1 && right <= n - 1) {

			if (sum >= s) {
				answer = Math.min(answer, len);
				sum -= arr[left];
				len--;
				left++;
			} else {
				right++;
				len++;
				sum += arr[right];
			}

		}
		if (answer == Integer.MAX_VALUE)
			System.out.println("0");
		else
			System.out.println(answer);
	}
}