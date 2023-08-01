import java.io.*;
import java.util.*;

class Solution
{
    static int n;
	static int[] arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			n = Integer.parseInt(bf.readLine());
			arr = new int[100];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			check(n);
			System.out.println("#" + tc + " " + (arr[99] - arr[0]));
		}

	}

	public static void check(int cnt) {
		if(cnt == 0) {
			return;
		}
		
		arr[99] -= 1;
		arr[0] += 1;
		Arrays.sort(arr);
		
		check(cnt-1);

	}
}
