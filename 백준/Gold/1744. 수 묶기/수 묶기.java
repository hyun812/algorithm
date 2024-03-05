import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(bf.readLine().trim());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);
		int idx = 0;
		boolean flag = false;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			
			int target = arr[i];

			if (target == 0) {
				if (!flag) {
					idx = i + 1;
				} else {
					answer += (temp * target);
					temp = 0;
				}
				break;
			}

			if (target > 0) {
				if (!flag) {
					idx = i;
				} else {
					answer += temp;
					temp = 0;
					idx = i;
				}
				break;
			}

			if (!flag) {
				temp = target;
				flag = true;
			} else {
				answer += (temp * target);
				flag = false;
				temp = 0;
			}
			idx = i+1;
		}

		answer += temp;
		flag = false;
		temp = 0;

		for (int i = n - 1; i >= idx; i--) {
			int target = arr[i];

			if (!flag) {
				temp = target;
				flag = true;
			} else {
				if (temp > 1 && target > 1) {
					answer += (temp * target);
					flag = false;
					temp = 0;
				} else {
					answer += temp;
					temp = target;
				}
			}
		}

		answer += temp;
		System.out.println(answer);
	}

}

//음수가아니면
//큰수끼리 묶음
//
//음수면 음수끼리 묶음
// 음수 더작은수끼리 묶으면 커짐
//정렬