import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[] arr;
	static int max;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트 케이스 개수
		int t = Integer.parseInt(bf.readLine());

		// 테스트 케이 개수 만큼 반복
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken()); // 나무의 개수
			
			arr = new int[n];
			max = Integer.MIN_VALUE;
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(max < arr[i]) max = arr[i];
			}
			
			int two=0, one=0; // 필요한 2의개수 , 1의개수
			
			for(int i=0; i<n; i++) {
				if(max == arr[i]) continue;
				
				int temp = max-arr[i];
				two += temp/2;
				one += temp%2;
			}
			
			if(two > one) {
				while(true) {
					if(Math.abs(two-one) <= 1) break;
					two--;
					one += 2;	
				}
			}
			
			ans = 0;
			if(two > one) {
				ans = 2*two;
			}else if(two < one) {
				ans = 2*one-1;
			}else {
				ans = one+two;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}