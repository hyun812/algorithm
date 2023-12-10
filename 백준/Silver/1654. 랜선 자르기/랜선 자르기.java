import java.io.*;
import java.util.*;

public class Main {
	static int k, m;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		k = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		m = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

		arr = new int[k];
		
		long max = 0;

		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long min = 1;
		long mid = 0;
		
		while(min <= max) {
			mid = (min + max) / 2;
			
			long sum = 0;
			for(int i=0; i<k; i++) {
				sum += arr[i]/mid;
			}
			if(sum < m) {
				max = mid-1;	
			}else {
				min = mid+1;			
			}
		}
		
		System.out.println((max+min)/2);
//		System.out.println(min);
//		System.out.println(mid);
	}
}