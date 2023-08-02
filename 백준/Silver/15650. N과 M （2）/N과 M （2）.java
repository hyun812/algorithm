
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] nums;
	static int n;
	static int m;
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		nums = new int[m];
		
		comb(0,0);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == m) {
			for(int i=0; i<nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<n; i++) {
			nums[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
}




