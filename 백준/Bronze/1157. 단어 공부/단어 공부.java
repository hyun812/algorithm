import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String target = bf.readLine();
		
		target = target.toUpperCase();
		
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		int max = 0;
		char result = ' ';
		for(int i=0; i<target.length(); i++) {
			int idx = target.charAt(i)-'A';
			arr[idx]++;
			
			if(arr[idx] < max) continue;
			else if(arr[idx] == max) {
				result = '?';
				
			}else {
				result = target.charAt(i);
				max = arr[idx];
			}
		}
		
		
		System.out.println(result);
	}
}
