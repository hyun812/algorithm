
import java.io.*;
import java.util.*;

public class Main { 
	static int n;
	static int m;
	static int[] arr;
	static int[] nums;
	static boolean[] checked;
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		nums = new int[m];
		checked = new boolean[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		check(0);
	}
	
	public static void check(int cnt) {
		if(m == cnt) {
			for(int i=0; i<nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!checked[i]) {
				nums[cnt] = arr[i];
				checked[i] = true;
				check(cnt+1);
				checked[i] = false;
			}
		}
	}
}
