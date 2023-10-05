import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static ArrayList<Long> list;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(bf.readLine());
		list = new ArrayList<>();
		if(n <= 10) System.out.println(n);
		else if(n > 1022) System.out.println(-1);
		else {
			for(int i=0; i<10; i++) {
				solution(i, 1);
			}
			Collections.sort(list);
			System.out.println(list.get(n));
		}
	}
	
	// 10
	// 21 20 210
	// 32 31 30 321 320 ..
	
	private static void solution(long num, int len) {
		if(len > 10) return;
				
		list.add(num);
		for(int i=0; i<num%10; i++) {
			solution((num*10)+i, len+1);
		}
		
	}
	
	
}