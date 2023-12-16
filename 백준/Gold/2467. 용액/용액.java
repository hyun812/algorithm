import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int a = 0;
		int b = 0;
		
		int left = 0;
		int right = n-1;
		
		int min = Integer.MAX_VALUE;
		
		while(left < right) {
			int temp = arr[left] + arr[right];
			int sum = Math.abs(arr[left] + arr[right]);
			
			if(min > sum) {
				min = sum;
				a = arr[left];
				b = arr[right];
			}
			
			if(temp < 0) {
				left++;
			}else {
				right--;
			}
		}
		
		System.out.println(a + " " + b);
	}
	
	
	
	
}