

import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int[] num;
	static int[] ope;
	static int[] make;
	static int n;
	static int max;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc<=t; tc++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			
			ope = new int[4];
			num = new int[n];
			make = new int[n-1];
		
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<4; i++) {
				ope[i] =Integer.parseInt(st.nextToken()); 
			}
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			
			check(0);
			
		 	sb.append("#").append(tc).append(" ").append(max-min).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static void check(int cnt) {
		if(n-1 == cnt) {
			minmax();
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(ope[i] == 0) continue;
			ope[i]--;
			make[cnt] = i;
			check(cnt+1);
			ope[i]++;
		}
	}
	
	public static void minmax() {
		int ans = num[0];
		for(int i=0; i<n-1; i++) {
			// +
			if(make[i] == 0) {
				ans+=num[i+1];
			}
			// -
			else if(make[i] == 1) {
				ans-=num[i+1];
			}
			// *
			else if(make[i] == 2) {
				ans*=num[i+1];
			}
			// /
			else if(make[i] == 3) {
				ans/=num[i+1];
			}
		}
		max = Math.max(max, ans);
		min = Math.min(min, ans);
	}
}
