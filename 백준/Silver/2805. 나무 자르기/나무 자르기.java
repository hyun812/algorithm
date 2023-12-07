import java.io.*;
import java.util.*;

public class Main {
	static int k, m;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		k = Integer.parseInt(st.nextToken()); // 나무의 수
		m = Integer.parseInt(st.nextToken()); // 나무 길이

		arr = new int[k];

		
		long max = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		// 10 15 17 20
		
		long min = 0;
		long mid = 0;

		while (min <= max) {
			mid = (min+max)/2;
			
			long len = 0;
			
			for(int i=0; i<k; i++) {
				if(arr[i] > mid) {
					len += arr[i] - mid;
				}
			}
			
			if(len < m) { // 작으면 더많은 나무를 더 짧게 잘라야함
				max = mid - 1;
			}else {
				min = mid +1;
			}
		}

		System.out.println(min-1);
	}


}