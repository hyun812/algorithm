import java.util.*;
import java.io.*;

public class Solution {

	static int n;
	static int[] nums;
	static int[] ope;
	static int max;
	static int min;

	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		for(int tc = 1; tc<=t; tc++) {
			
			n = Integer.parseInt(bf.readLine());
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			ope = new int[4];
			nums = new int[n];
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<4; i++) {
				ope[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			doit(0, nums[0]);
			System.out.println("#"+tc+" " + (max-min));
		}
	}
	
	private static void doit(int cnt, int num) {
		if(cnt == n-1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(ope[i] > 0) {
				ope[i]--;
				doit(cnt+1, calc(num, cnt, i));
				ope[i]++;	
			}
		}
	}
	
	private static int calc(int num, int cnt, int idx) { // num은 기존 계산한 값 , cnt는 숫자의 인덱스, idx는 사용할 연산자의 인덱스
		int res = num;
		switch(idx) {
		case 0:
			res+=nums[cnt+1];
			break;
		case 1:
			res-=nums[cnt+1];
			break;
		case 2:
			res*=nums[cnt+1];
			break;
		case 3:
			res/=nums[cnt+1];
			break;
		}
		
		return res;
	}
}