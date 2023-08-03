
import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static Integer[] nums;
	static boolean[] isSelected;
	static int n;
	static int m;
	static LinkedHashSet<String> result;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		isSelected = new boolean[n];
		nums = new Integer[m];
		result = new LinkedHashSet<String>();
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		check(0);
		for(String s : result) {
			System.out.println(s);
		}
		
	}

	public static void check(int cnt) {
		if (cnt == m) {
			StringBuilder sb = new StringBuilder();
			for(int i : nums) {
				sb.append(i).append(" ");	
			}
			result.add(sb.toString());
			return;
		}

		for (int i = 0; i < n; i++) {
			nums[cnt] = arr[i];
			check(cnt + 1);

		}

	}
}
