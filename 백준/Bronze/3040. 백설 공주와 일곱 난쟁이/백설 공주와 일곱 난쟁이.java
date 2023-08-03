
import java.io.*;
import java.util.*;

public class Main {
//	static int N;
//	static int M;
	static int[] input;
	static int[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[9];
		result = new int[7];
		
		for(int i=0; i<9; i++) {
			input[i] = Integer.parseInt(bf.readLine());
		}
		
		combi(0,0);
		
	}
	
	private static void combi (int cnt, int start) {
		
		if(cnt == 7) {
			int sum =0;
			for(int i=0; i<result.length; i++) {
				sum += result[i];
			}
			if(sum == 100) {
				for(int i=0; i<result.length; i++) {
					System.out.println(result[i]);
				}
					
			}
			
			return;
		}
		
		for(int i=start; i<9; i++) {
			result[cnt] = input[i];
			combi(cnt+1, i+1);
		}
	}
}
