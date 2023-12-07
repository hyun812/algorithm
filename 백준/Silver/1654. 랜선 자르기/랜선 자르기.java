import java.io.*;
import java.util.*;

public class Main {
	static int k, n;
	static long[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new long[k];

		
		long max = 0;

		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			max = Math.max(max, arr[i]);
		}
		
		
		long min = 1;
		long mid = 0;

		while (min <= max) {
			mid = (min+max)/2;
			
			long count = 0;
			
			for(int i=0; i<k; i++) {
				count += arr[i]/mid;
			}
			
			if(count < n) {
				max = mid - 1;
			}else {
				min = mid +1;
			}
		}

		System.out.println(min-1);
	}


}