
import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int n;
	static int m;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(bf.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			max = -1;
			arr = new int[n];
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			check(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	public static void check(int cnt, int start, int we) {
		if(cnt == 2) {
			if(we <= m) {
				max = Math.max(max, we);	
			}
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			check(cnt+1, i+1, we+arr[i]);
		}
	}
}
