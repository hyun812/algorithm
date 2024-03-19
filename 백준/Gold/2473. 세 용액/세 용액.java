import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static long[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());

		arr = new long[n];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		long[] res = new long[3];

		long min = 4000000001L;

		for (int i = 0; i < n - 2; i++) {
			
			int left = i+1;
			int right = n - 1;
			
			while (left < right) {
				long temp = arr[left] + arr[right] + arr[i];
				long value = Math.abs(temp);

				if (min > value) {
					min = value;
					res[0] = arr[left];
					res[1] = arr[right];
					res[2] = arr[i];
				}

				if (temp > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		Arrays.sort(res);

		for(int i=0; i<3; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}