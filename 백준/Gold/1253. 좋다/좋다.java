import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		answer = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			int target = arr[i];

			int left = 0;
			int right = n - 1;
			while (left < right) {
				if(left == i) {
					left++;
					continue;
				}else if(right == i) {
					right--;
					continue;
				}
				
				int sum = arr[left] + arr[right];
				
				if(sum == target) {
					answer++;
					break;
				}else if(sum > target) {
					right--;
				}else if(sum < target) {
					left++;
				}
			}
		}
		
		System.out.println(answer);

	}
}