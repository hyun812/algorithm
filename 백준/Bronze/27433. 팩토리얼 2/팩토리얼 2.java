
import java.io.*;
import java.util.*;

public class Main {

//	static int[] arr;
//	static Integer[] nums;
//	static boolean[] isSelected;
//	static int n;
//	static int m;
//	static LinkedHashSet<String> result;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(bf.readLine());
//		m = Integer.parseInt(st.nextToken());
		long result = check(n);
		System.out.println(result);
//		arr = new int[n];
//		isSelected = new boolean[n];
//		nums = new Integer[m];
//		result = new LinkedHashSet<String>();
//		
//		st = new StringTokenizer(bf.readLine());
//		for (int i = 0; i < n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//
//		Arrays.sort(arr);
//		check(0, 0);
//		for(String s : result) {
//			System.out.println(s);
//		}
		
	}

	public static long check(int n) {
		if (n == 0) {
			return 1;
		}

		return n * check(n-1);

	}
}
