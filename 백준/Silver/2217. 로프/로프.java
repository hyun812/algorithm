import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			int w = Integer.parseInt(bf.readLine());
			arr[i] = w;
		}
		
		Arrays.sort(arr);
		
		int max = arr[n-1];
		int cnt = 1;
		
		// 큰거부터 확인
		for(int i=n-1; i>=0; i--) {
			int target = arr[i];
			
			max = Math.max(max, target*cnt);
			cnt++;
		
		}
		
		System.out.println(max);

	}
}