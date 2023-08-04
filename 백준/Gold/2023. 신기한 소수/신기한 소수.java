

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		check(0, n);
		
		System.out.println(sb.toString());
	}
	// n=1 > 10~99
	
	// 0 ~ 9
	// 2 >> check(2 1) >> check(23,0) 
	// 3
	// 5
	// 7
	public static void check(int num , int n) {
		if(n==0) {
			sb.append(num).append("\n");
		}
		
		for(int i=0; i<10; i++) {
			int target = (10*num) + i;
			if(n > 0 && isPrime(target)) {
				check(target, n-1);
			}
			
		}
		
	}
	
	public static boolean isPrime(int num) {
		if(num < 2) return false;
		
		for(int i=2; i*i<=num; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
